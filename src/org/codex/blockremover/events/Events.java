package org.codex.blockremover.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.codex.blockremover.main.BlockRemoverMain;

public class Events implements Listener {
	
	public static Player player;
	public static Block block;
	public static World world;
	public static ItemMeta meta;
	
	@EventHandler
	  public void onPlayerInteract(PlayerInteractEvent e)	  
	  {
	    if (!e.getPlayer().getItemInHand().equals(BlockRemoverMain.getStackRemover())) {
	      return;
	    }
	    
	    if ((e.getPlayer().getItemInHand().equals(BlockRemoverMain.getStackRemover()) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_AIR)))) {
	    	return;
		    }
	    
	    if ((e.getPlayer().getItemInHand().equals(BlockRemoverMain.getStackRemover()) && (!e.getClickedBlock().getType().equals(Material.AIR)) && (!e.getClickedBlock().getType().equals(null))))
	    {
	      Block b = e.getClickedBlock();
	      int x = b.getX();
	      int z = b.getZ();
	      
	      for (int y = 0; y < 256; y++)	    	  
	      {
	        Location loc = new Location(b.getWorld(), x, y, z);
	        if ((loc.getBlock().getType().equals(Material.SAND)) || (loc.getBlock().getType().equals(Material.GRAVEL)) || (loc.getBlock().getType().equals(Material.DRAGON_EGG)) || (loc.getBlock().getType().equals(Material.ANVIL))) {
	        	loc.getBlock().setType(Material.AIR);
	        }
	      }
	    }
	  }
	}

