package com.InfinityRaider.AgriCraft.compatibility.pneumaticcooking;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PneumaticCookingHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("pneumaticcooking:cornKernel");
        Item fruit1 = (Item) Item.itemRegistry.getObject("pneumaticcooking:cornCob");
        Block plant1 = (Block) Block.blockRegistry.getObject("pneumaticcooking:cropCorn");
        try {
            CropPlantHandler.registerPlant(new CropPlantPC(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected String modId() {
        return "pneumaticcooking";
    }
}
