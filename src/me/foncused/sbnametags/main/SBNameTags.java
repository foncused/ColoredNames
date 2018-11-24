package me.foncused.sbnametags.main;

import me.foncused.sbnametags.config.Config;
import me.foncused.sbnametags.event.player.PlayerJoin;
import me.foncused.sbnametags.runnable.Runnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SBNameTags extends JavaPlugin {

	@Override
	public void onEnable() {
		this.initialize();
		this.registerConfig();
		this.registerEvents();
		this.registerRunnables();
	}

	private void initialize() {
		Runnable.inject(this);
	}

	private void registerConfig() {
		Config.createConfig(this);
		Runnable.setTablist(this.getConfig().getBoolean("tablist"));
	}

	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
	}

	private void registerRunnables() {
		Runnable.runPlayerNameTagsTask();
	}

}
