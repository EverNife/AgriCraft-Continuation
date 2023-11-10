package com.InfinityRaider.AgriCraft.compatibility.steamcraft2;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Steamcraft2Helper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("steamcraft2:ItemTeaSeed");
        Item fruit1 = (Item) Item.itemRegistry.getObject("steamcraft2:ItemTeaLeaf");
        Block plant1 = (Block) Block.blockRegistry.getObject("steamcraft2:BlockTeaPlant");
        try {
            CropPlantHandler.registerPlant(new CropPlantSC2(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected String modId() {
        return "steamcraft2";
    }
}
