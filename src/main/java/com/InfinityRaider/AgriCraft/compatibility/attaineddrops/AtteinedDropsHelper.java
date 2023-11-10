package com.InfinityRaider.AgriCraft.compatibility.attaineddrops;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AtteinedDropsHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("attainedDrops:blockMobPlant");
        Item fruit1 = (Item) Item.itemRegistry.getObject("attainedDrops:plantSeed");
        Block plant1 = (Block) Block.blockRegistry.getObject("attainedDrops:blockMobPlant");
        try {
            CropPlantHandler.registerPlant(new CropPlantAD(new ItemStack(seed1), new ItemStack(fruit1, 1, 1), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected String modId() {
        return "alchemyrocks";
    }
}
