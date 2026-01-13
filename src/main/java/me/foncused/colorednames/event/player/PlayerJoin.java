package me.foncused.colorednames.event.player;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {
		final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		sb.registerNewTeam("black");
		sb.registerNewTeam("dark_blue");
		sb.registerNewTeam("dark_green");
		sb.registerNewTeam("dark_aqua");
		sb.registerNewTeam("dark_red");
		sb.registerNewTeam("dark_purple");
		sb.registerNewTeam("gold");
		sb.registerNewTeam("gray");
		sb.registerNewTeam("dark_gray");
		sb.registerNewTeam("blue");
		sb.registerNewTeam("green");
		sb.registerNewTeam("aqua");
		sb.registerNewTeam("red");
		sb.registerNewTeam("light_purple");
		sb.registerNewTeam("yellow");
		sb.registerNewTeam("white");
		event.getPlayer().setScoreboard(sb);
	}

}
