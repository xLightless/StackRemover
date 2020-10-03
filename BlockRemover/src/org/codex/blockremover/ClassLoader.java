package org.codex.blockremover;

import org.bukkit.plugin.java.JavaPlugin;
import org.codex.blockremover.commands.BlockRemoverCommand;
import org.codex.blockremover.events.Events;

public class ClassLoader extends JavaPlugin {

	@Override
	public void onEnable() {
		loadCommands();
		registerEvents();
	}
	
	
	public void loadCommands() {
		getCommand("stackremover").setExecutor(new BlockRemoverCommand());
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new Events(), this);
	}
}
