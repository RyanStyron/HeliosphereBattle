package mc.rysty.heliospherebattle;

import org.bukkit.plugin.java.JavaPlugin;

import mc.rysty.heliosphereminigames.HelioSphereMinigames;
import mc.rysty.heliosphereminigames.utils.QueuesFileManager;

import mc.rysty.heliospherebattle.register.EventRegister;
import mc.rysty.heliospherebattle.utils.filemanagers.PlayerDataFileManager;

public class HelioSphereBattle extends JavaPlugin {

    private static HelioSphereBattle plugin;

    public static HelioSphereBattle getInstance() {
        return plugin;
    }

    private static PlayerDataFileManager playerDataFileManager = PlayerDataFileManager.getInstance();

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        playerDataFileManager.setup(this);

        new EventRegister(this);

        System.out.println("HS-Battle enabled!");
    }

    public void onDisable() {
        System.out.println("HS-Battle disabled!");
    }

    public static PlayerDataFileManager getPlayerDataFile() {
        return playerDataFileManager;
    }

    public static QueuesFileManager getMinigamesQueuesFile() {
        return HelioSphereMinigames.getQueuesFile();
    }
}