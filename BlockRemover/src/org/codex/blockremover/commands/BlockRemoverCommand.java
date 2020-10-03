package org.codex.blockremover.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.codex.blockremover.main.BlockRemoverGUI;
import org.codex.blockremover.main.BlockRemoverMain;

import net.md_5.bungee.api.ChatColor;

public class BlockRemoverCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) {
		
		Player player = (Player) sender;
		
		if ((sender instanceof Player) && (sender.hasPermission("sr.use") || sender.isOp())) {
			
			if (args.length == 0) {
				
				player.openInventory(BlockRemoverGUI.getInventory(player));
				
			}
			
			if (args.length != 0) {
				player.sendMessage(ChatColor.RED + "Invalid args.");
			}
			
		//	player.getInventory().setItem(0, BlockRemoverMain.getStackRemover());	
			
		}
		
		return false;
	}

}
