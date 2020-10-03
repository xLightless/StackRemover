package org.codex.blockremover.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.codex.blockremover.main.BlockRemoverGUI;
import org.codex.blockremover.main.BlockRemoverMain;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	public static Player player;
	public static Block block;
	public static World world;
	public static ItemMeta meta;
	
	
	// getStackRemover
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
	
	//getSlabPlacer
	@EventHandler
	  public void onPlayerInteractSLAB(PlayerInteractEvent e)	  
	  {
	    if (!e.getPlayer().getItemInHand().equals(BlockRemoverMain.getSlabPlacer())) {
	      return;
	    }
	    
	    if ((e.getPlayer().getItemInHand().equals(BlockRemoverMain.getSlabPlacer()) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_AIR)))) {
	    	return;
		    }
	    
	    if ((e.getPlayer().getItemInHand().equals(BlockRemoverMain.getSlabPlacer()) && (!e.getClickedBlock().getType().equals(Material.AIR)) && (!e.getClickedBlock().getType().equals(null))))
	    {
	      Block b = e.getClickedBlock();
	      int x = b.getX();
	      int z = b.getZ();
	      
	      //replaces vertical blocks to air for slab busting
	      for (int y = 1; y < 256; y++)	    	  
	      {
	        Location loc = new Location(b.getWorld(), x, y, z);

    		if ((loc.getBlock().getType().equals(Material.AIR)) || (loc.getBlock().getType().equals(Material.SAND)) || (loc.getBlock().getType().equals(Material.DRAGON_EGG)) || (loc.getBlock().getType().equals(Material.ANVIL)) || (loc.getBlock().getType().equals(Material.GRAVEL))) {
    		loc.getBlock().setType(Material.AIR);
    		
    		}
	      }

	        for (int y1 = 0; y1 < 2; y1++) {
	        	Location loc2 = new Location(b.getWorld(), x, y1, z);
	        	if ((loc2.getBlock().getType().equals(Material.AIR)) || (loc2.getBlock().getType().equals(Material.SAND)) || (loc2.getBlock().getType().equals(Material.DRAGON_EGG)) || (loc2.getBlock().getType().equals(Material.ANVIL)) || (loc2.getBlock().getType().equals(Material.GRAVEL))) {
	        	loc2.getBlock().setType(Material.STEP);
	        	}   	
	        }
	    }
	  }	
	//Cancels Slab placer Block place via Player interaction.
	@EventHandler
	public void onSlabPlacerInteract (BlockPlaceEvent e) {
		
	    if (!e.getPlayer().getItemInHand().equals(BlockRemoverMain.getSlabPlacer())) {
		      return;
		    }
	    
	    if (e.getPlayer().getItemInHand().equals(BlockRemoverMain.getSlabPlacer())) {
		      e.setCancelled(true);
		    }
		}
	}