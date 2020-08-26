package mc.rysty.heliospherebattle;

import org.bukkit.plugin.java.JavaPlugin;

public class HelioSphereBattle extends JavaPlugin {

    private static HelioSphereBattle plugin;

    public static HelioSphereBattle getInstance() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;

        System.out.println("HS-Battle enabled!");
    }

    public void onDisbale() {
        System.out.println("HS-Battle disabled!");
    }
}