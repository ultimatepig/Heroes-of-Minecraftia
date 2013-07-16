package org.github.hm;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class HM extends JavaPlugin {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		if(cmd.getName().equalsIgnoreCase("hmhelp")){
			if(sender.hasPermission("hmhelp")){
				sender.sendMessage("Heroes of Minecraftia Help");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You don't have permission!");
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("hmjoin")){
			if(sender.hasPermission("hmjoin")){
				
			}
		}
		return false;
	}
	Logger logger = Logger.getLogger("Minecraft");

	public void onDisable() {
		logger.info("HM v0.1 has been disabled!");
	}

	public void onEnable() {
		logger.info("HM v0.1 has been enabled!");
		getServer().getPluginManager().registerEvents(new Heroes(), this);
	}
}
