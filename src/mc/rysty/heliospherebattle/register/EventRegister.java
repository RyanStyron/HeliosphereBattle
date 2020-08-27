package mc.rysty.heliospherebattle.register;

import org.bukkit.plugin.PluginManager;

import mc.rysty.heliospherebattle.HelioSphereBattle;
import mc.rysty.heliospherebattle.general.SpawnProtection;

public class EventRegister {

    private HelioSphereBattle plugin = HelioSphereBattle.getInstance();
    private PluginManager manager = plugin.getServer().getPluginManager();

    public EventRegister(HelioSphereBattle plugin) {
        manager.registerEvents(new SpawnProtection(), plugin);
    }
}