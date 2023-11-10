package com.InfinityRaider.AgriCraft.compatibility.zoocraftdiscoveries;

import com.InfinityRaider.AgriCraft.compatibility.ModHelper;
import com.InfinityRaider.AgriCraft.farming.CropPlantHandler;
import com.InfinityRaider.AgriCraft.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZoocraftDiscoveriesHelper extends ModHelper {
    @Override
    protected void initPlants() {
        Item seed1 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:chive_seed");
        Item fruit1 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:10");
        Block plant1 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_chive");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed1), new ItemStack(fruit1, 1, 0), plant1));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed2 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:parsley_seed");
        Item fruit2 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:8");
        Block plant2 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_parsley");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed2), new ItemStack(fruit2, 1, 0), plant2));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed3 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:rosemary_seed");
        Item fruit3 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:7");
        Block plant3 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_rosemary");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed3), new ItemStack(fruit3, 1, 0), plant3));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed4 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:lemongrass_seed");
        Item fruit4 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:14");
        Block plant4 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_lemongrass");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed4), new ItemStack(fruit4, 1, 0), plant4));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed5 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:coriander_seed");
        Item fruit5 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:5");
        Block plant5 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_coriander");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed5), new ItemStack(fruit5, 1, 0), plant5));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed6 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:tarragon_seed");
        Item fruit6 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:11");
        Block plant6 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_tarragon");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed6), new ItemStack(fruit6, 1, 0), plant6));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed7 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:saffron_seed");
        Item fruit7 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:12");
        Block plant7 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_saffron");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed7), new ItemStack(fruit7, 1, 0), plant7));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed8 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:thyme_seed");
        Item fruit8 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:4");
        Block plant8 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_thyme");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed8), new ItemStack(fruit8, 1, 0), plant8));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed9 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:bay_seed");
        Item fruit9 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:13");
        Block plant9 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_bay");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed9), new ItemStack(fruit9, 1, 0), plant9));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed10 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:mint_seed:6");
        Item fruit10 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:6");
        Block plant10 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_mint");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed10), new ItemStack(fruit10, 1, 0), plant10));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed11 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:basil_seed");
        Item fruit11 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:1");
        Block plant11 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_basil");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed11), new ItemStack(fruit11, 1, 0), plant11));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed12 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:dill_seed");
        Item fruit12 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:9");
        Block plant12 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_dill");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed12), new ItemStack(fruit12, 1, 0), plant12));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
        Item seed13 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:sage_seed");
        Item fruit13 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:3");
        Block plant13 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_sage");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed13), new ItemStack(fruit13, 1, 0), plant13));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }

        Item seed14 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:oregano_seed");
        Item fruit14 = (Item) Item.itemRegistry.getObject("ZoocraftDiscoveries:herb:2");
        Block plant14 = (Block) Block.blockRegistry.getObject("ZoocraftDiscoveries:herbs_oregano");
        try {
            CropPlantHandler.registerPlant(new CropPlantZD(new ItemStack(seed14), new ItemStack(fruit14, 1, 0), plant14));
        } catch (Exception e) {
            if(ConfigurationHandler.debug) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected String modId() {
        return "ZoocraftDiscoveries";
    }
}
