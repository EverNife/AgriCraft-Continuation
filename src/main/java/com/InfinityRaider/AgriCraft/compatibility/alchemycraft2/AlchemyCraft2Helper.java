package com.InfinityRaider.AgriCraft.compatibility.alchemycraft2;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.compatibility.applemilktea.CropPlantAppleMilkTea;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlant;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import com.InfinityRaider.AgriCraft.utility.LogHelper;
import com.InfinityRaider.AgriCraft.utility.exception.DuplicateCropPlantException;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlchemyCraft2Helper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("ac2:item.WaterSeeds");
        Item fruit1 = (Item) Item.itemRegistry.getObject("ac2:item.Water");
        Block plant1 = (Block) Block.blockRegistry.getObject("ac2:tile.WaterCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantAC2(new ItemStack(seed1), new ItemStack(fruit1, 1, 1), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed2 = (Item) Item.itemRegistry.getObject("ac2:item.AEtherSeeds");
        Item fruit2 = (Item) Item.itemRegistry.getObject("ac2:item.AEther");
        Block plant2 = (Block) Block.blockRegistry.getObject("ac2:tile.AEtherCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantAC2(new ItemStack(seed2), new ItemStack(fruit2, 1, 1), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed3 = (Item) Item.itemRegistry.getObject("ac2:item.FireSeeds");
        Item fruit3 = (Item) Item.itemRegistry.getObject("ac2:item.Fire");
        Block plant3 = (Block) Block.blockRegistry.getObject("ac2:tile.FireCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantAC2(new ItemStack(seed3), new ItemStack(fruit3, 1, 1), plant3));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed4 = (Item) Item.itemRegistry.getObject("ac2:item.EarthSeeds");
        Item fruit4 = (Item) Item.itemRegistry.getObject("ac2:item.Earth");
        Block plant4 = (Block) Block.blockRegistry.getObject("ac2:tile.EarthCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantAC2(new ItemStack(seed4), new ItemStack(fruit4, 1, 1), plant4));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed5 = (Item) Item.itemRegistry.getObject("ac2:item.AirSeeds");
        Item fruit5 = (Item) Item.itemRegistry.getObject("ac2:item.Air");
        Block plant5 = (Block) Block.blockRegistry.getObject("ac2:tile.AirCrop");
        try {
            CropPlantHandler.registerPlant(new CropPlantAC2(new ItemStack(seed5), new ItemStack(fruit5, 1, 1), plant5));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected String modId() {
        return "ac2";
    }
}
