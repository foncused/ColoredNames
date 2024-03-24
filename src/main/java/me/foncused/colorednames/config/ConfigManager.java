package me.foncused.colorednames.config;

import me.foncused.colorednames.util.ColoredNamesUtil;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

	private final FileConfiguration config;
	private boolean tablist;
	private int refresh;

	public ConfigManager(final FileConfiguration config) {
		this.config = config;
	}

	public void validate() {

		// tablist
		this.tablist = this.config.getBoolean("tablist", true);
		ColoredNamesUtil.console(this.tablist ? "Tablist enabled" : "Tablist disabled");

		// refresh
		final int refresh = this.config.getInt("refresh", 3);
		if(refresh <= 0) {
			this.refresh = 3;
			ColoredNamesUtil.consoleWarning("Set refresh to " + refresh + " seconds is not safe, reverting to default...");
		} else {
			this.refresh = refresh;
		}
		ColoredNamesUtil.console("Set refresh to " + this.refresh);

	}

	public boolean isTablist() {
		return this.tablist;
	}

	public int getRefresh() {
		return this.refresh;
	}

}
