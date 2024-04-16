package br.com.finalcraft.evernife.agricraft.sprinklersystem;

import br.com.finalcraft.evernife.agricraft.listener.TickListener;
import br.com.finalcraft.evernife.agricraft.minecraft.vector.BlockPos;
import br.com.finalcraft.evernife.agricraft.minecraft.vector.ChunkPos;
import br.com.finalcraft.evernife.agricraft.minecraft.vector.CuboidSelection;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import com.InfinityRaider.AgriCraft.tileentity.TileEntityCrop;
import com.InfinityRaider.AgriCraft.tileentity.irrigation.TileEntitySprinkler;
import com.InfinityRaider.AgriCraft.utility.DebugHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.chunk.Chunk;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ChunkSprinklerOptimizer {

    private static final Logger logger = Logger.getLogger(ChunkSprinklerOptimizer.class.getName());
    private final Random random = new Random();
    private final Chunk chunk;
    private final ChunkPos chunkPos;
    private final Map<BlockPos, PositionedSprinkler> sprinklersOnThisChunk = new HashMap<>();
    private final Map<BlockPos, PositionedCrop> cropsOnThisChunk = new HashMap<>();


    private static final int MAX_SPRINKLERS_BOOST = 2;
    private transient long lastTimeTicked = 0;

    private transient long lastTimeScanned = 0;
    private transient final int scanIntervalSeconds = 5;

    public ChunkSprinklerOptimizer(Chunk chunk) {
        this.chunk = chunk;
        this.chunkPos = ChunkPos.from(chunk);
    }

    public Map<BlockPos, PositionedSprinkler> getSprinklersOnThisChunk() {
        return sprinklersOnThisChunk;
    }

    public Map<BlockPos, PositionedCrop> getCropsOnThisChunk() {
        return cropsOnThisChunk;
    }

    public void scanChunkForSprinklers(){

        if (TickListener.getTickCounter() - lastTimeScanned < (20 * scanIntervalSeconds)){
            return;
        }

        lastTimeScanned = TickListener.getTickCounter();

        sprinklersOnThisChunk.clear();
        cropsOnThisChunk.clear();

        for (Map.Entry<ChunkPosition, ? extends TileEntity> chunkPositionEntry : ((Map<ChunkPosition, ? extends TileEntity>) chunk.chunkTileEntityMap).entrySet()) {
            TileEntity tileEntity = chunkPositionEntry.getValue();

            if (tileEntity.isInvalid()){
                continue;
            }

            if (tileEntity instanceof TileEntitySprinkler){
                TileEntitySprinkler tileEntitySprinkler = (TileEntitySprinkler) tileEntity;

                if (tileEntitySprinkler.optmizedSprinkleCheckAndDrainWater(scanIntervalSeconds) == false){
                    continue;
                }

                BlockPos worldBlockPos = chunkPos.getBlock(chunkPositionEntry.getKey().chunkPosX, chunkPositionEntry.getKey().chunkPosY, chunkPositionEntry.getKey().chunkPosZ);
                BlockPos innerChunkBlockPos = new BlockPos(chunkPositionEntry.getKey().chunkPosX, chunkPositionEntry.getKey().chunkPosY, chunkPositionEntry.getKey().chunkPosZ);
                PositionedSprinkler positionedSprinkler = new PositionedSprinkler(innerChunkBlockPos, tileEntitySprinkler);
                sprinklersOnThisChunk.put(worldBlockPos, positionedSprinkler);
            }

            if (tileEntity instanceof TileEntityCrop){
                TileEntityCrop tileEntityCrop = (TileEntityCrop) tileEntity;
                BlockPos worldBlockPos = chunkPos.getBlock(chunkPositionEntry.getKey().chunkPosX, chunkPositionEntry.getKey().chunkPosY, chunkPositionEntry.getKey().chunkPosZ);
                BlockPos innerChunkBlockPos = new BlockPos(chunkPositionEntry.getKey().chunkPosX, chunkPositionEntry.getKey().chunkPosY, chunkPositionEntry.getKey().chunkPosZ);
                PositionedCrop positionedCrop = new PositionedCrop(innerChunkBlockPos, tileEntityCrop);
                cropsOnThisChunk.put(worldBlockPos, positionedCrop);
            }

        }

        if (DebugHelper.isDebugEnabled){
            logger.info("[" + TickListener.getTickCounter() + "] Scanned Chunk: " + chunkPos + " for Sprinklers amd Crops. " +
                "\n - Sprinklers: " + sprinklersOnThisChunk.size() + "" +
                "\n - Crops: " + cropsOnThisChunk.size());
        }

        for (PositionedCrop positionedCrop : cropsOnThisChunk.values()) {

            positionedCrop.setNearSprinklers(
                    sprinklersOnThisChunk.values().stream()
                            .filter(positionedSprinkler -> positionedSprinkler.getCuboidSelection().contains(positionedCrop.getBlockPos()))
                            .collect(Collectors.toList())
            );

        }

    }

    public void tickTheEntireChunk(){

        long diffLastTick = TickListener.getTickCounter() - lastTimeTicked;

        if (diffLastTick < 3){
            return;
        }

        if (DebugHelper.isDebugEnabled){
            logger.info("[" + TickListener.getTickCounter() + "] Ticking Chunk: " + chunkPos + " for Sprinklers");
        }

        lastTimeTicked = TickListener.getTickCounter();

        boolean irrigateBellow = diffLastTick > 60;

        //The idea is to scan all crops on the entire chunk and simulate the irrigate on every one of them at once
        for (PositionedCrop positionedCrop : cropsOnThisChunk.values()) {
            try {
                tickTheCrop(positionedCrop, irrigateBellow);
            }catch (Exception e){
                logger.severe("Error while ticking crop: " + positionedCrop.getBlockPos() + " on chunk: " + chunkPos);
                e.printStackTrace();
            }
        }
    }

    private void tickTheCrop(PositionedCrop positionedCrop, boolean irrigateBellow){
        TileEntityCrop crop = positionedCrop.getTileEntity();

        if (crop.isInvalid()){
            return;
        }

        //Count near sprinklers
        long multiplierTimes = 1 + positionedCrop.getNearSprinklersBoost();

        //first, simulate BlockCrop::updateTick
        if(crop.hasPlant() || crop.hasWeed()) {

            if (crop.isMature() && crop.hasWeed() && ConfigurationHandler.enableWeeds){
                crop.spreadWeed();
            } else if (crop.isFertile()) {
                //multiplier from growth stat
                double growthBonus = 1.0 + crop.getGrowth() / 10.0;
                //multiplier defined in the config
                float global = ConfigurationHandler.growthMultiplier;
                //crop dependent base growth rate
                float growthRate = (float) crop.getGrowthRate();
                //determine if growth tick should be applied or skipped

                int timesToApplyGrowthTick = 0;

                for (long i = 0; i < multiplierTimes; i++) {
                    boolean shouldGrow = (random.nextDouble() <= (growthRate * growthBonus * global) / 100);
                    if (shouldGrow) {
                        timesToApplyGrowthTick++;
                    }
                }

                if (timesToApplyGrowthTick > 0){
                    if (DebugHelper.isDebugEnabled){
                        logger.info(String.format("  - Ticked crop: %s on chunk: %s. (willIrrigateSoil=%s)   SprinklersNear: %s FinalSprinkleBoost: %s",
                            positionedCrop.getBlockPos(),
                            chunkPos,
                            irrigateBellow,
                            multiplierTimes,
                            timesToApplyGrowthTick
                        ));
                    }

                    crop.applyGrowthTick(timesToApplyGrowthTick);
                }

            }
        } else {
            //15% chance to spawn weeds
            if(ConfigurationHandler.enableWeeds && (Math.random() < (ConfigurationHandler.weedSpawnChance + (ConfigurationHandler.weedSpawnChance * multiplierTimes)))) {
                crop.spawnWeed();
            } else if (crop.isCrossCrop()) {
                crop.crossOver();
            }

        }

        if (irrigateBellow){
            Block block = chunk.getBlock(positionedCrop.getBlockPos().getX(), positionedCrop.getBlockPos().getY() -1, positionedCrop.getBlockPos().getZ());

            if (block instanceof BlockFarmland){
                BlockPos worldBlockPos = chunkPos.getBlock(positionedCrop.getBlockPos().getX() , positionedCrop.getBlockPos().getY() -1, positionedCrop.getBlockPos().getZ());
                int x = worldBlockPos.getX();
                int y = worldBlockPos.getY();
                int z = worldBlockPos.getZ();

                int farmlandMeta = this.chunk.worldObj.getBlockMetadata(x, y, z);

                // irrigate farmland
                int newMeta = Math.min(7, farmlandMeta + 2);
                this.chunk.worldObj.setBlockMetadataWithNotify(x, y, z, 7, newMeta);
                this.chunk.worldObj.markBlockForUpdate(x, y, z);
            }
        }
    }

    public static class PositionedTileEntity<T> {
        private BlockPos blockPos;
        private T tileEntity;

        public PositionedTileEntity(BlockPos blockPos, T tileEntity) {
            this.blockPos = blockPos;
            this.tileEntity = tileEntity;
        }

        public BlockPos getBlockPos() {
            return blockPos;
        }

        public T getTileEntity() {
            return tileEntity;
        }
    }

    public static class PositionedCrop extends PositionedTileEntity<TileEntityCrop>{
        private List<PositionedSprinkler> nearSprinklers = new ArrayList<>();

        public PositionedCrop(BlockPos blockPos, TileEntityCrop tileEntity) {
            super(blockPos, tileEntity);
        }

        public List<PositionedSprinkler> getNearSprinklers() {
            return nearSprinklers;
        }


        public long getNearSprinklersBoost(){
            long boosts = 0;
            for (PositionedSprinkler nearSprinkler : getNearSprinklers()) {
                if (nearSprinkler.getTileEntity().isInvalid()) {
                    continue;
                }
                boosts++;
                if (boosts >= MAX_SPRINKLERS_BOOST){
                    break;
                }
            }
            return boosts;
        }

        public void setNearSprinklers(List<PositionedSprinkler> nearSprinklers) {
            this.nearSprinklers = nearSprinklers;
        }
    }

    public static class PositionedSprinkler extends PositionedTileEntity<TileEntitySprinkler>{
        private final CuboidSelection cuboidSelection;

        public PositionedSprinkler(BlockPos blockPos, TileEntitySprinkler tileEntity) {
            super(blockPos, tileEntity);
            this.cuboidSelection = CuboidSelection.of(blockPos).expand(new BlockPos(3,0,3), new BlockPos(-3,-3,-3));
        }

        public CuboidSelection getCuboidSelection() {
            return cuboidSelection;
        }

    }
}
