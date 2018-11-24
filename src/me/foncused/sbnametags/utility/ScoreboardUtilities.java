package me.foncused.sbnametags.utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class ScoreboardUtilities {

	public static void setColors(final Set<Team> teams) {
		teams.forEach(team -> {
			switch(team.getName()) {
				case "black": team.setPrefix(ChatColor.BLACK.toString()); break;
				case "dark_blue": team.setPrefix(ChatColor.DARK_BLUE.toString()); break;
				case "dark_green": team.setPrefix(ChatColor.DARK_GREEN.toString()); break;
				case "dark_aqua": team.setPrefix(ChatColor.DARK_AQUA.toString()); break;
				case "dark_red": team.setPrefix(ChatColor.DARK_RED.toString()); break;
				case "dark_purple": team.setPrefix(ChatColor.DARK_PURPLE.toString()); break;
				case "gold": team.setPrefix(ChatColor.GOLD.toString()); break;
				case "gray": team.setPrefix(ChatColor.GRAY.toString()); break;
				case "dark_gray": team.setPrefix(ChatColor.DARK_GRAY.toString()); break;
				case "blue": team.setPrefix(ChatColor.BLUE.toString()); break;
				case "green": team.setPrefix(ChatColor.GREEN.toString()); break;
				case "aqua": team.setPrefix(ChatColor.AQUA.toString()); break;
				case "red": team.setPrefix(ChatColor.RED.toString()); break;
				case "light_purple": team.setPrefix(ChatColor.LIGHT_PURPLE.toString()); break;
				case "yellow": team.setPrefix(ChatColor.YELLOW.toString()); break;
				case "white": team.setPrefix(ChatColor.WHITE.toString()); break;
				case "obfuscated": team.setPrefix(ChatColor.MAGIC.toString()); break;
				case "bold": team.setPrefix(ChatColor.BOLD.toString()); break;
				case "strikethrough": team.setPrefix(ChatColor.STRIKETHROUGH.toString()); break;
				case "underline": team.setPrefix(ChatColor.UNDERLINE.toString()); break;
				case "italic": team.setPrefix(ChatColor.ITALIC.toString()); break;
				default: team.setPrefix(ChatColor.WHITE.toString()); break;
			}
		});
	}

	public static void selectTeam(final String teamName, final Set<Team> teams, final Player player) {
		final String name = player.getName();
		teams.stream().filter(team -> (!(team.hasEntry(name)))).forEach(team -> {
			if(!(team.getName().equals(teamName))) {
				team.removeEntry(name);
			} else {
				team.addEntry(name);
			}
		});
	}

}
