package mc.rysty.heliospherebattle.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import mc.rysty.heliospherebattle.HelioSphereBattle;

public class MessageUtils {

    private static HelioSphereBattle plugin = HelioSphereBattle.getInstance();
    private static FileConfiguration config = plugin.getConfig();

    public static String convertChatColors(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void message(CommandSender sender, String message) {
        sender.sendMessage(convertChatColors(message));
    }

    public static void configMessage(CommandSender sender, String configString) {
        message(sender, config.getString(configString));
    }

    public static void configMessage(CommandSender sender, String configString, String target, String replacement) {
        message(sender, config.getString(configString).replace(target, replacement));
    }

    public static void consoleError() {
        configMessage(Bukkit.getConsoleSender(), "console-error");
    }

    public static void permissionError(CommandSender sender) {
        configMessage(sender, "permission-error");
    }

    public static void playerError(CommandSender sender) {
        configMessage(sender, "player-error");
    }

    public static void argumentError(CommandSender sender, String usage) {
        configMessage(sender, "argument-error", "<usage>", usage);
    }

    public static void versionError(Player player, String setVersion, boolean isVersionTooHigh) {
        if (isVersionTooHigh)
            configMessage(player, "version-high-error", "<version>", setVersion);
        else
            configMessage(player, "version-low-error", "<version>", setVersion);
    }
}