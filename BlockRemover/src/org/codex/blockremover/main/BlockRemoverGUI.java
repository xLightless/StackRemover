package org.codex.blockremover.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;

public class BlockRemoverGUI {
	
	
	public static Inventory getInventory(Player p) {
		Inventory GUI = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Click a Tool Type to use:");
		
		//Set Item Slots Here
		GUI.setItem(0, BlockRemoverMain.getStackRemover());
		GUI.setItem(1, BlockRemoverMain.getSlabPlacer());
		//
		return GUI;
	}

}
