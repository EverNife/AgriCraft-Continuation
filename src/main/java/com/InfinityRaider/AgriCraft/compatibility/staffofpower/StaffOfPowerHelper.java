package com.InfinityRaider.AgriCraft.compatibility.staffofpower;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StaffOfPowerHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("csstaffopower:item.illuminationPlantSeeds");
        Item fruit1 = (Item) Item.itemRegistry.getObject("csstaffopower:item.illuminationEssence");
        Block plant1 = (Block) Block.blockRegistry.getObject("csstaffopower:tile.illuminationPlant");
        try {
            CropPlantHandler.registerPlant(new CropPlantSOP(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed2 = (Item) Item.itemRegistry.getObject("csstaffopower:item.firePlantSeeds");
        Item fruit2 = (Item) Item.itemRegistry.getObject("csstaffopower:item.fireEssence");
        Block plant2 = (Block) Block.blockRegistry.getObject("csstaffopower:tile.firePlant");
        try {
            CropPlantHandler.registerPlant(new CropPlantSOP(new ItemStack(seed2), new ItemStack(fruit2, 1, 0), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected String modId() {
        return "csstaffopower";
    }
}
