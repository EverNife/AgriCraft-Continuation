package com.InfinityRaider.AgriCraft.compatibility.netherlicious;

import com.InfinityRaider.AgriCraft.api.v1.BlockWithMeta;
import com.InfinityRaider.AgriCraft.api.v1.IGrowthRequirement;
import com.InfinityRaider.AgriCraft.api.v3.ICrop;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlant;
import com.InfinityRaider.AgriCraft.farming.growthrequirement.GrowthRequirementHandler;
import com.InfinityRaider.AgriCraft.reference.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class CropPlantN extends CropPlant {
    Item seed;
    Item fruit;
    Block plant;

    public CropPlantN(ItemStack seed, ItemStack fruit, Block plant) {
        this.seed = seed.getItem();
        this.fruit = fruit.getItem();
        this.plant = plant;
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack getSeed() {
        return new ItemStack(seed, 1);
    }

    @Override
    public Block getBlock() {
        return plant;
    }

    @Override
    public ArrayList<ItemStack> getAllFruits() {
        ArrayList<ItemStack> fruits = new ArrayList<ItemStack>();
        fruits.add(new ItemStack(fruit, 1));
        return fruits;
    }

    @Override
    public ItemStack getRandomFruit(Random rand) {
        return new ItemStack(fruit, 1);
    }

    @Override
    public ArrayList<ItemStack> getFruitsOnHarvest(int gain, Random rand) {
        int amount = rand.nextInt(3) + 3;
        ArrayList<ItemStack> list = new ArrayList<>();
        while(amount > 0) {
            list.add(getRandomFruit(rand));
            amount--;
        }
        return list;
    }


    @Override
    public boolean canBonemeal() {
        return true;
    }

    @Override
    protected IGrowthRequirement initGrowthRequirement() {
        return GrowthRequirementHandler.getNewBuilder().soil(new BlockWithMeta(Blocks.soul_sand)).brightnessRange(0, 8).build();
    }

    @Override
    public boolean onAllowedGrowthTick(World world, int x, int y, int z, int oldGrowthStage, ICrop crop) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public float getHeight(int meta) {
        return Constants.UNIT*13;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getPlantIcon(int growthStage) {
        int meta = 1;
        if(growthStage==0 || growthStage==1) {
            meta = 0;
        } else if(growthStage==5 || growthStage==6) {
            meta = 2;
        } else if(growthStage==7) {
            meta = 3;
        }
        return plant.getIcon(0, meta);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean renderAsFlower() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getInformation() {
        // todo: update journal
        return "agricraft.journal_AMT."+seed.getUnlocalizedName()+":";
    }
}
