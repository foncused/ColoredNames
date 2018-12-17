package me.foncused.sbnametags;

import me.foncused.sbnametags.event.player.PlayerJoin;
import me.foncused.sbnametags.runnable.Runnable;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SBNameTags extends JavaPlugin {

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
		final Runnable runnable = new Runnable(this);
		final FileConfiguration config = this.getConfig();
		runnable.setTablist(config.getBoolean("tablist"));
		runnable.setRefresh(config.getInt("refresh"));
		runnable.runPlayerNameTagsTask();
	}

}
