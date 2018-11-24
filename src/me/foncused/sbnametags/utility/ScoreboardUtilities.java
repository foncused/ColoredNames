package me.foncused.sbnametags.utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class ScoreboardUtilities {

	public static void setColors(final Set<Team> teams) {
		teams.forEach(team -> {
			switch(team.getName()) {
				case "black": team.setColor(ChatColor.BLACK); break;
				case "dark_blue": team.setColor(ChatColor.DARK_BLUE); break;
				case "dark_green": team.setColor(ChatColor.DARK_GREEN); break;
				case "dark_aqua": team.setColor(ChatColor.DARK_AQUA); break;
				case "dark_red": team.setColor(ChatColor.DARK_RED); break;
				case "dark_purple": team.setColor(ChatColor.DARK_PURPLE); break;
				case "gold": team.setColor(ChatColor.GOLD); break;
				case "gray": team.setColor(ChatColor.GRAY); break;
				case "dark_gray": team.setColor(ChatColor.DARK_GRAY); break;
				case "blue": team.setColor(ChatColor.BLUE); break;
				case "green": team.setColor(ChatColor.GREEN); break;
				case "aqua": team.setColor(ChatColor.AQUA); break;
				case "red": team.setColor(ChatColor.RED); break;
				case "light_purple": team.setColor(ChatColor.LIGHT_PURPLE); break;
				case "yellow": team.setColor(ChatColor.YELLOW); break;
				case "white": team.setColor(ChatColor.WHITE); break;
				case "obfuscated": team.setColor(ChatColor.MAGIC); break;
				case "bold": team.setColor(ChatColor.BOLD); break;
				case "strikethrough": team.setColor(ChatColor.STRIKETHROUGH); break;
				case "underline": team.setColor(ChatColor.UNDERLINE); break;
				case "italic": team.setColor(ChatColor.ITALIC); break;
				default: team.setColor(ChatColor.WHITE); break;
			}
		});
	}

	public static void selectTeam(final Player player, final String team, final Set<Team> teams) {
		teams.forEach(t -> {
			final String name = player.getName();
			if(t.getName().equals(team)) {
				t.addEntry(name);
			} else {
				t.removeEntry(name);
			}
		});
	}

}
