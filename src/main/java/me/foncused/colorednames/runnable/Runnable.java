package me.foncused.colorednames.runnable;

import me.foncused.colorednames.ColoredNames;
import me.foncused.colorednames.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;

import java.util.Collections;
import java.util.Set;

public class Runnable {

	private final ColoredNames plugin;
	private final ConfigManager cm;

	public Runnable(final ColoredNames plugin) {
		this.plugin = plugin;
		this.cm = this.plugin.getConfigManager();
	}

	public void runPlayerNameTagsTask() {
		new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.getOnlinePlayers().forEach(p1 -> {
					final Set<Team> teams = Collections.unmodifiableSet(p1.getScoreboard().getTeams());
					Bukkit.getOnlinePlayers().forEach(p2 -> {
						String team = "white";
						for(final String p : Bukkit.getPluginManager()
								.getPermission("colorednames.all")
								.getChildren()
								.keySet()
						) {
							if(p2.hasPermission(p)) {
								team = p.split("\\.")[1];
								break;
							}
						}
						for(final Team t : teams) {
							final String name = p2.getName();
							if(t.getName().equals(team)) {
								t.addEntry(name);
							} else {
								t.removeEntry(name);
							}
							switch(t.getName()) {
								case "black" -> t.setColor(ChatColor.BLACK);
								case "dark_blue" -> t.setColor(ChatColor.DARK_BLUE);
								case "dark_green" -> t.setColor(ChatColor.DARK_GREEN);
								case "dark_aqua" -> t.setColor(ChatColor.DARK_AQUA);
								case "dark_red" -> t.setColor(ChatColor.DARK_RED);
								case "dark_purple" -> t.setColor(ChatColor.DARK_PURPLE);
								case "gold" -> t.setColor(ChatColor.GOLD);
								case "gray" -> t.setColor(ChatColor.GRAY);
								case "dark_gray" -> t.setColor(ChatColor.DARK_GRAY);
								case "blue" -> t.setColor(ChatColor.BLUE);
								case "green" -> t.setColor(ChatColor.GREEN);
								case "aqua" -> t.setColor(ChatColor.AQUA);
								case "red" -> t.setColor(ChatColor.RED);
								case "light_purple" -> t.setColor(ChatColor.LIGHT_PURPLE);
								case "yellow" -> t.setColor(ChatColor.YELLOW);
								case "obfuscated" -> t.setColor(ChatColor.MAGIC);
								case "bold" -> t.setColor(ChatColor.BOLD);
								case "strikethrough" -> t.setColor(ChatColor.STRIKETHROUGH);
								case "underline" -> t.setColor(ChatColor.UNDERLINE);
								case "italic" -> t.setColor(ChatColor.ITALIC);
								default -> t.setColor(ChatColor.WHITE);
							}
						}
						if(!(cm.isTablist())) {
							p2.setPlayerListName(ChatColor.RESET + p2.getPlayerListName());
						}
					});
				});
			}
		}.runTaskTimer(this.plugin, 0, this.cm.getRefresh() * 20);
	}

}
