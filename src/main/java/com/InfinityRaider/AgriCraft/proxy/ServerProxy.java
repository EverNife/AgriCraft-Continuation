package com.InfinityRaider.AgriCraft.proxy;

import com.InfinityRaider.AgriCraft.commands.CMDAgriCraft;
import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.block.Block;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ServerProxy extends CommonProxy {
    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public World getClientWorld() {
        return null;
    }

    @Override
    public World getWorldByDimensionId(int dimension) {
        return FMLServerHandler.instance().getServer().worldServerForDimension(dimension);
    }

    @Override
    public void registerRenderers() {}

    @Override
    public void initNEI() {}

    @Override
    public void hideItemInNEI(ItemStack stack) {}

    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();

        ((ServerCommandManager)MinecraftServer.getServer().getCommandManager()).registerCommand(new CMDAgriCraft());
    }

    @Override
    public int getRenderId(Block block) {
        return -1;
    }

    @Override
    public void registerVillagerSkin(int id, String resource) {
    }
}
