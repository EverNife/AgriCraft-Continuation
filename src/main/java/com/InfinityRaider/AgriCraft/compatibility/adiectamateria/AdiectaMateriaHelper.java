package com.InfinityRaider.AgriCraft.compatibility.adiectamateria;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlant;
import com.InfinityRaider.AgriCraft.utility.LogHelper;
import com.InfinityRaider.AgriCraft.utility.exception.DuplicateCropPlantException;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AdiectaMateriaHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item flaxSeed = (Item) Item.itemRegistry.getObject("adiectamateria:rice_seed");
        CropPlant flaxCrop = new CropPlantAM(flaxSeed);
        try {
            CropPlantHandler.registerPlant(flaxCrop);
        } catch (DuplicateCropPlantException e) {
            LogHelper.printStackTrace(e);
        }
    }


    @Override
    protected String modId() {
        return "adiectamateria";
    }
}
