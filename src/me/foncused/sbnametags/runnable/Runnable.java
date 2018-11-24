package me.foncused.sbnametags.runnable;

import me.foncused.sbnametags.utility.ScoreboardUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;

import java.util.Collections;
import java.util.Set;

public class Runnable {

	private static JavaPlugin instance;
	private static boolean tablist = true;

	public static void inject(final JavaPlugin instance) {
		Runnable.instance = instance;
	}

	public static void setTablist(final boolean tablist) {
		Runnable.tablist = tablist;
	}

	private Runnable() {
		throw new IllegalStateException();
	}

	public static void runPlayerNameTagsTask() {
		new BukkitRunnable() {
			public void run() {
				Bukkit.getOnlinePlayers().forEach(p1 -> {
					final Set<Team> teams = Collections.unmodifiableSet(p1.getScoreboard().getTeams());
					Bukkit.getOnlinePlayers().forEach(p2 -> {
						String team;
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
						ScoreboardUtilities.selectTeam(team, teams, p2);
						ScoreboardUtilities.setColors(teams);
						if(!(tablist)) {
							p2.setPlayerListName(ChatColor.RESET + p2.getPlayerListName());
						}
					});
				});
			}
		}.runTaskTimer(instance, 0, 1 * 20);
	}

}
