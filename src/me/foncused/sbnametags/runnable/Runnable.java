package me.foncused.sbnametags.runnable;

import me.foncused.sbnametags.SBNameTags;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;

import java.util.Collections;
import java.util.Set;

public class Runnable {

	private final SBNameTags plugin;
	private final boolean tablist;
	private final int refresh;

	public Runnable(final SBNameTags plugin, final boolean tablist, final int refresh) {
		this.plugin = plugin;
		this.tablist = tablist;
		this.refresh = refresh;
	}

	public void runPlayerNameTagsTask() {
		new BukkitRunnable() {
			public void run() {
				Bukkit.getOnlinePlayers().forEach(p1 -> {
					final Set<Team> teams = Collections.unmodifiableSet(p1.getScoreboard().getTeams());
					Bukkit.getOnlinePlayers().forEach(p2 -> {
						final String team;
						if(p2.hasPermission("sbnametags.black")) {
							team = "black";
						} else if(p2.hasPermission("sbnametags.dark_blue")) {
							team = "dark_blue";
						} else if(p2.hasPermission("sbnametags.dark_green")) {
							team = "dark_green";
						} else if(p2.hasPermission("sbnametags.dark_aqua")) {
							team = "dark_aqua";
						} else if(p2.hasPermission("sbnametags.dark_red")) {
							team = "dark_red";
						} else if(p2.hasPermission("sbnametags.dark_purple")) {
							team = "dark_purple";
						} else if(p2.hasPermission("sbnametags.gold")) {
							team = "gold";
						} else if(p2.hasPermission("sbnametags.gray")) {
							team = "gray";
						} else if(p2.hasPermission("sbnametags.dark_gray")) {
							team = "dark_gray";
						} else if(p2.hasPermission("sbnametags.blue")) {
							team = "blue";
						} else if(p2.hasPermission("sbnametags.green")) {
							team = "green";
						} else if(p2.hasPermission("sbnametags.aqua")) {
							team = "aqua";
						} else if(p2.hasPermission("sbnametags.red")) {
							team = "red";
						} else if(p2.hasPermission("sbnametags.light_purple")) {
							team = "light_purple";
						} else if(p2.hasPermission("sbnametags.yellow")) {
							team = "yellow";
						} else if(p2.hasPermission("sbnametags.white")) {
							team = "white";
						} else if(p2.hasPermission("sbnametags.obfuscated")) {
							team = "obfuscated";
						} else if(p2.hasPermission("sbnametags.bold")) {
							team = "bold";
						} else if(p2.hasPermission("sbnametags.strikethrough")) {
							team = "strikethrough";
						} else if(p2.hasPermission("sbnametags.underline")) {
							team = "underline";
						} else if(p2.hasPermission("sbnametags.italic")) {
							team = "italic";
						} else {
							return;
						}
						teams.forEach(t -> {
							final String name = p2.getName();
							if(t.getName().equals(team)) {
								t.addEntry(name);
							} else {
								t.removeEntry(name);
							}
							switch(t.getName()) {
								case "black": t.setColor(ChatColor.BLACK); break;
								case "dark_blue": t.setColor(ChatColor.DARK_BLUE); break;
								case "dark_green": t.setColor(ChatColor.DARK_GREEN); break;
								case "dark_aqua": t.setColor(ChatColor.DARK_AQUA); break;
								case "dark_red": t.setColor(ChatColor.DARK_RED); break;
								case "dark_purple": t.setColor(ChatColor.DARK_PURPLE); break;
								case "gold": t.setColor(ChatColor.GOLD); break;
								case "gray": t.setColor(ChatColor.GRAY); break;
								case "dark_gray": t.setColor(ChatColor.DARK_GRAY); break;
								case "blue": t.setColor(ChatColor.BLUE); break;
								case "green": t.setColor(ChatColor.GREEN); break;
								case "aqua": t.setColor(ChatColor.AQUA); break;
								case "red": t.setColor(ChatColor.RED); break;
								case "light_purple": t.setColor(ChatColor.LIGHT_PURPLE); break;
								case "yellow": t.setColor(ChatColor.YELLOW); break;
								case "white": t.setColor(ChatColor.WHITE); break;
								case "obfuscated": t.setColor(ChatColor.MAGIC); break;
								case "bold": t.setColor(ChatColor.BOLD); break;
								case "strikethrough": t.setColor(ChatColor.STRIKETHROUGH); break;
								case "underline": t.setColor(ChatColor.UNDERLINE); break;
								case "italic": t.setColor(ChatColor.ITALIC); break;
								default: t.setColor(ChatColor.WHITE); break;
							}
						});
						if(!(tablist)) {
							p2.setPlayerListName(ChatColor.RESET + p2.getPlayerListName());
						}
					});
				});
			}
		}.runTaskTimer(this.plugin, 0, this.refresh * 20);
	}

}
