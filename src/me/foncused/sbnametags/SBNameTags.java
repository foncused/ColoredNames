package me.foncused.sbnametags;

import me.foncused.sbnametags.event.player.PlayerJoin;
import me.foncused.sbnametags.runnable.Runnable;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SBNameTags extends JavaPlugin {

	private final String PREFIX = "[SBNameTags] ";

	@Override
	public void onEnable() {
		this.registerConfig();
		this.registerEvents();
		this.registerRunnables();
	}

	private void registerConfig() {
		this.saveDefaultConfig();
	}

	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
	}

	private void registerRunnables() {
		final FileConfiguration config = this.getConfig();
		final boolean tablist = config.getBoolean("tablist", true);
		this.console(tablist ? "Tablist mode activated" : "Tablist mode deactivated");
		int refresh = config.getInt("refresh", 3);
		if(refresh <= 0) {
			this.consoleWarning("Set refresh to " + refresh + " seconds is not safe, reverting to default...");
			refresh = 3;
		}
		this.console("Set refresh to " + refresh + " seconds");
		new Runnable(this, tablist, refresh).runPlayerNameTagsTask();
	}

	private void console(final String message) {
		Bukkit.getLogger().info(this.PREFIX + message);
	}

	private void consoleWarning(final String message) {
		Bukkit.getLogger().warning(this.PREFIX + message);
	}

}
