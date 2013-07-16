package org.github.hm;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class Heroes extends HM implements Listener{
	static ArrayList <Player> players = new ArrayList<Player>();
	static ArrayList <String> team = new ArrayList<String>(); 
	public static String getTeam(Player player){
		int index = players.lastIndexOf(player);
		if(index == -1){
			return "-1";
		}
		return team.get(index);
	}
	public boolean isPlaying(Player player){
		if(players.contains(player)){
			return true;
		}
		return false;
	}
	@EventHandler //calls eventhandler
	public void hunger(FoodLevelChangeEvent event){ // when this event happens, do:
		if(event.getEntityType() == EntityType.PLAYER){
			Player player = (Player) event.getEntity();
		
			if(isPlaying(player) == true){
				player.setFoodLevel(20); //keeps food level on full, so can regen this is a comment for future reference 
			}
		}
	}
	@EventHandler
	public void pvp(EntityDamageByEntityEvent event){ 
		Entity damager = (Player) event.getDamager();
		Entity player = event.getEntity();
		if(getTeam((Player) damager) == getTeam((Player) player)){
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void inventory(InventoryOpenEvent event){
		Player player = (Player) event.getPlayer();
		if(isPlaying(player) == true){
			event.setCancelled(true);
		}
	}
}
