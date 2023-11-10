package com.InfinityRaider.AgriCraft.compatibility.actuallyadditions;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlant;
import com.InfinityRaider.AgriCraft.utility.LogHelper;
import com.InfinityRaider.AgriCraft.utility.exception.DuplicateCropPlantException;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ActuallyAdditionHelper extends ModHelper {
    @Override
    protected void initPlants() {
        // Flax
        Block flaxPlant = (Block) Block.blockRegistry.getObject("ActuallyAdditions:blockFlax");
        Item flaxSeed = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemFlaxSeed");
        CropPlant flaxCrop = new CropPlantAA(flaxSeed, flaxPlant, new ItemStack(flaxPlant, 1, 0));
        try {
            CropPlantHandler.registerPlant(flaxCrop);
        } catch (DuplicateCropPlantException e) {
            LogHelper.printStackTrace(e);
        }

        // Canola
        Block canolaPlant = (Block) Block.blockRegistry.getObject("ActuallyAdditions:blockCanola");
        Item canolaSeed = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemCanolaSeed");
        Item canolaFruit = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemMisc:13");
        CropPlant canolaCrop = new CropPlantAA(canolaSeed, canolaPlant, new ItemStack(canolaFruit, 1, 11));
        try {
            CropPlantHandler.registerPlant(canolaCrop);
        } catch (DuplicateCropPlantException e) {
            LogHelper.printStackTrace(e);
        }

        // Rice
        Block ricePlant = (Block) Block.blockRegistry.getObject("flaxCropActuallyAdditions:blockRice");
        Item riceSeed = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemRiceSeed");
        Item riceFruit = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemFood:16");
        CropPlant riceCrop = new CropPlantAA(riceSeed, ricePlant, new ItemStack(riceFruit, 1, 0));
        try {
            CropPlantHandler.registerPlant(riceCrop);
        } catch (DuplicateCropPlantException e) {
            LogHelper.printStackTrace(e);
        }

        // Coffee
        Block coffePlant = (Block) Block.blockRegistry.getObject("ActuallyAdditions:blockCoffee");
        Item coffeeSeed = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemCoffeeSeed");
        Item coffeeFruit = (Item) Item.itemRegistry.getObject("ActuallyAdditions:itemCoffeeBeans");
        CropPlant coffeeCrop = new CropPlantAA(coffeeSeed, coffePlant, new ItemStack(coffeeFruit, 1, 0));
        try {
            CropPlantHandler.registerPlant(coffeeCrop);
        } catch (DuplicateCropPlantException e) {
            LogHelper.printStackTrace(e);
        }
    }

    @Override
    protected String modId() {
        return "ActuallyAdditions";
    }
}
