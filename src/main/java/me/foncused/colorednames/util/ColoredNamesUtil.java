package me.foncused.colorednames.util;

import me.foncused.colorednames.ColoredNames;
import org.bukkit.Bukkit;

public class ColoredNamesUtil {

	public static void console(final String message) {
		Bukkit.getLogger().info(ColoredNames.PREFIX + message);
	}

	public static void consoleWarning(final String message) {
		Bukkit.getLogger().warning(ColoredNames.PREFIX + message);
	}

}
