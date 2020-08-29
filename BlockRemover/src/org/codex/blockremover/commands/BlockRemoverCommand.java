package org.codex.blockremover.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.codex.blockremover.main.BlockRemoverMain;

public class BlockRemoverCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] cmdArgs) {
		
		Player player = (Player) sender;
		
		if ((sender instanceof Player) && (sender.hasPermission("sr.use") || sender.isOp())) {

			player.getInventory().setItem(0, BlockRemoverMain.getStackRemover());	
			
		}
		
		return false;
	}

}
