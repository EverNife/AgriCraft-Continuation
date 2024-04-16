package com.InfinityRaider.AgriCraft.commands;

import br.com.finalcraft.evernife.agricraft.commands.argumento.MultiArgumentos;
import com.InfinityRaider.AgriCraft.utility.DebugHelper;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class CMDAgriCraftClient implements ICommand {

    private final List<String> aliases = new ArrayList<>();

    public CMDAgriCraftClient() {
        this.aliases.add(this.getCommandName());
    }

    @Override
    public String getCommandName() {
        return "agricraftclient";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender) {
        return this.getCommandName();
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        MultiArgumentos argumentos = new MultiArgumentos(args);

        if (argumentos.get(0).equalsIgnoreCase("debug")){

            Boolean newState = argumentos.get(1).getBoolean();

            if (newState == null){
                sender.addChatMessage(new ChatComponentText("§4§l ▶ §e/agricraft debug §c<on|off>"));
                return;
            }

            sender.addChatMessage(new ChatComponentText("§2§l ▶ §eAgricraft DebugState is now: " + (newState ? "§a§lON" : "§c§lOFF")));

            DebugHelper.isDebugEnabled = newState;
            return;
        }

        sender.addChatMessage(new ChatComponentText("§2§l ▶ §e/agricraft debug <on|off>"));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] astring, int i) {
        return false;
    }

    @Override
    public int compareTo(Object arg0) {
        return 0;
    }
}
