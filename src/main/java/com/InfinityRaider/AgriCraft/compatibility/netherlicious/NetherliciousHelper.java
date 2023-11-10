package com.InfinityRaider.AgriCraft.compatibility.netherlicious;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetherliciousHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem");
        Item fruit1 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem");
        Block plant1 = (Block) Block.blockRegistry.getObject("netherlicious:CrimsonWartCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantN(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        // doesn't work todo
        Item seed2 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem:1");
        Item fruit2 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem:1");
        Block plant2 = (Block) Block.blockRegistry.getObject("netherlicious:WarpedWartCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantN(new ItemStack(seed2), new ItemStack(fruit2, 1, 0), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        // doesn't work todo
        Item seed3 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem:2");
        Item fruit3 = (Item) Item.itemRegistry.getObject("netherlicious:WartItem:2");
        Block plant3 = (Block) Block.blockRegistry.getObject("netherlicious:SoggyWartCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantN(new ItemStack(seed3), new ItemStack(fruit3, 1, 0), plant3));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected String modId() {
        return "netherlicious";
    }
}
