package com.InfinityRaider.AgriCraft.compatibility.extremefood;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtremeFoodHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("extremefoodmod:seedTomato");
        Item fruit1 = (Item) Item.itemRegistry.getObject("extremefoodmod:ingredientTomato");
        Block plant1 = (Block) Block.blockRegistry.getObject("extremefoodmod:cropTomato");
        try {
            CropPlantHandler.registerPlant(new CropPlantEF(new ItemStack(seed1), new ItemStack(fruit1, 1, 1), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected String modId() {
        return "extremefoodmod";
    }
}
