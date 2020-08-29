package org.codex.blockremover.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class BlockRemoverMain implements Listener {

	public static Player player;
	
	public static ItemStack getStackRemover() {
		ItemStack is = new ItemStack(Material.FEATHER);
		ItemMeta im = is.getItemMeta();
		List<String> lore = new ArrayList<String>();
		im.setDisplayName(ChatColor.AQUA + "Stack Remover");
		lore.add(ChatColor.GRAY + "Click a Physics Block to Stack Remove.");
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
		
	}
	
	
}
