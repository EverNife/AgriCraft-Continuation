package com.InfinityRaider.AgriCraft.compatibility.teaandbiscuits;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TeaAndBiscuitsHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("teaandbiscuits:strawberryseeds");
        Item fruit1 = (Item) Item.itemRegistry.getObject("teaandbiscuits:Strawberry");
        Block plant1 = (Block) Block.blockRegistry.getObject("teaandbiscuits:strawberryplant");
        try {
            CropPlantHandler.registerPlant(new CropPlantTAB(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed2 = (Item) Item.itemRegistry.getObject("teaandbiscuits:gingerseeds");
        Item fruit2 = (Item) Item.itemRegistry.getObject("teaandbiscuits:ginger");
        Block plant2 = (Block) Block.blockRegistry.getObject("teaandbiscuits:gingerplant");
        try {
            CropPlantHandler.registerPlant(new CropPlantTAB(new ItemStack(seed2), new ItemStack(fruit2, 1, 0), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed3 = (Item) Item.itemRegistry.getObject("teaandbiscuits:teaseeds");
        Item fruit3 = (Item) Item.itemRegistry.getObject("teaandbiscuits:tea_leaf");
        Block plant3 = (Block) Block.blockRegistry.getObject("teaandbiscuits:teaplant");
        try {
            CropPlantHandler.registerPlant(new CropPlantTAB(new ItemStack(seed3), new ItemStack(fruit3, 1, 0), plant3));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected String modId() {
        return "teaandbiscuits";
    }
}
