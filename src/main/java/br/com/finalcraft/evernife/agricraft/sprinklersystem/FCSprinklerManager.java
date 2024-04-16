package br.com.finalcraft.evernife.agricraft.sprinklersystem;

import br.com.finalcraft.evernife.agricraft.minecraft.vector.ChunkPos;
import net.minecraft.world.chunk.Chunk;

import java.util.HashMap;
import java.util.Map;

public class FCSprinklerManager {

    private static Map<ChunkPos, ChunkSprinklerOptimizer> chunkSprinklerHolderMap = new HashMap<>();

    public static ChunkSprinklerOptimizer getOrCreateSprinklerOptmizer(Chunk chunk){
        return chunkSprinklerHolderMap.computeIfAbsent(ChunkPos.from(chunk), chunkPos1 -> {
            return new ChunkSprinklerOptimizer(chunk);
        });
    }

    public static void removeChunkOptimizers(Chunk chunk){
        chunkSprinklerHolderMap.remove(ChunkPos.from(chunk));
    }


}
