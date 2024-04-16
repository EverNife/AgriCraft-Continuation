package br.com.finalcraft.evernnifeagricraft.minecraft.vector;

import net.minecraft.world.chunk.Chunk;

import java.util.Objects;

public class ChunkPos {
    protected final int x;
    protected final int z;

    public ChunkPos(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static ChunkPos from(Chunk chunk){
        return new ChunkPos(chunk.xPosition, chunk.zPosition);
    }

    public ChunkPos(BlockPos block) {
        this.x = block.getX() >> 4;
        this.z = block.getZ() >> 4;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public int getXStart() {
        return this.x << 4;
    }

    public int getZStart() {
        return this.z << 4;
    }

    public int getXEnd() {
        return (this.x << 4) + 15;
    }

    public int getZEnd() {
        return (this.z << 4) + 15;
    }

    public BlockPos getBlock(int x, int y, int z) {
        return new BlockPos((this.x << 4) + x, y, (this.z << 4) + z);
    }

    @Override
    public String toString() {
        return serialize();
    }

    public String serialize(){
        return this.x + "|" + this.z;
    }

    public static ChunkPos deserialize(String serialized){
        String[] split = serialized.split("\\|");
        return new ChunkPos(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkPos chunkPos = (ChunkPos) o;
        return x == chunkPos.x && z == chunkPos.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}
