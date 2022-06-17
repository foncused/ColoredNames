package me.foncused.colorednames;

import me.foncused.colorednames.config.ConfigManager;
import me.foncused.colorednames.event.player.PlayerJoin;
import me.foncused.colorednames.runnable.Runnable;
import org.bukkit.plugin.java.JavaPlugin;

public class ColoredNames extends JavaPlugin {

	public static final String PREFIX = "[SBNameTags] ";

	private ConfigManager cm;

	@Override
	public void onEnable() {
		this.registerConfig();
		this.registerEvents();
		this.registerRunnables();
	}

	private void registerConfig() {
		this.saveDefaultConfig();
		this.cm = new ConfigManager(this.getConfig());
		this.cm.validate();
	}

	private void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
	}

	private void registerRunnables() {
		new Runnable(this).runPlayerNameTagsTask();
	}

	public ConfigManager getConfigManager() {
		return this.cm;
	}

}
