package com.InfinityRaider.AgriCraft.compatibility.kitchencraft_foods;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class KitchenCraftHelper extends ModHelper {
    // todo problem all crops from kitchencraft use kitchenCraftFoods:crop id
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed");
        Item fruit1 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie");
        Block plant1 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed2 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed:1");
        Item fruit2 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie:1");
        Block plant2 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed2), new ItemStack(fruit2, 1, 0), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed3 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed:2");
        Item fruit3 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie:2");
        Block plant3 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed3), new ItemStack(fruit3, 1, 0), plant3));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed4 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed:3");
        Item fruit4 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie:3");
        Block plant4 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed4), new ItemStack(fruit4, 1, 0), plant4));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed5 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed:4");
        Item fruit5 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie:4");
        Block plant5 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed5), new ItemStack(fruit5, 1, 0), plant5));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed6 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:seed:5");
        Item fruit6 = (Item) Item.itemRegistry.getObject("kitchenCraftFoods:veggie:5");
        Block plant6 = (Block) Block.blockRegistry.getObject("kitchenCraftFoods:crop");
        try {
            CropPlantHandler.registerPlant(new CropPlantKC(new ItemStack(seed6), new ItemStack(fruit6, 1, 0), plant6));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected String modId() {
        return "";
    }
}
