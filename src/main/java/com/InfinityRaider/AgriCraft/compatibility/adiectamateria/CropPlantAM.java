package com.InfinityRaider.AgriCraft.compatibility.adiectamateria;

import com.InfinityRaider.AgriCraft.api.v1.IGrowthRequirement;
import com.InfinityRaider.AgriCraft.api.v3.ICrop;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlant;
import com.InfinityRaider.AgriCraft.farming.growthrequirement.GrowthRequirementHandler;
import com.InfinityRaider.AgriCraft.reference.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class CropPlantAM extends CropPlant {
    private final Item seedAndFruit;

    public CropPlantAM(Item seedAndFruit) {
        this.seedAndFruit = seedAndFruit;
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public ItemStack getSeed() {
        return new ItemStack(seedAndFruit);
    }

    @Override
    public Block getBlock() {
        return (Block) Block.blockRegistry.getObject("adiectamateria:rice");
    }

    @Override
    public ArrayList<ItemStack> getAllFruits() {
        ArrayList<ItemStack> fruits = new ArrayList<>();
        fruits.add(new ItemStack(seedAndFruit));
        return fruits;
    }

    @Override
    public ItemStack getRandomFruit(Random rand) {
        return new ItemStack(seedAndFruit);
    }

    @Override
    public ArrayList<ItemStack> getFruitsOnHarvest(int gain, Random rand) {
        int amount = (int) (Math.ceil((gain + 0.00) / 3));
        ArrayList<ItemStack> list = new ArrayList<>();
        while (amount > 0) {
            list.add(new ItemStack(seedAndFruit, 2));
            amount--;
        }
        return list;
    }


    public boolean canBonemeal() {
        return true;
    }

    @Override
    protected IGrowthRequirement initGrowthRequirement() {
        return GrowthRequirementHandler.getNewBuilder().build();
    }

    @Override
    public boolean onAllowedGrowthTick(World world, int x, int y, int z, int oldGrowthStage, ICrop crop) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getHeight(int meta) {
        return Constants.UNIT * 13;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getPlantIcon(int growthStage) {
        return getBlock().getIcon(0, growthStage);
    }

    @Override
    public boolean renderAsFlower() {
        return false;
    }

    @Override
    public String getInformation() {
        // todo: update journal
        return "agricraft_journal.BoP_" + getBlock().getUnlocalizedName().substring(getBlock().getUnlocalizedName().indexOf('.') + 1);
    }
}
