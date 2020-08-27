package mc.rysty.heliospherebattle.general;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class SpawnProtection implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        Location location = entity.getLocation();
        World world = location.getWorld();

        if (world == Bukkit.getWorld("Battle"))
            if (location.distanceSquared(world.getSpawnLocation()) <= 10000)
                event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!canBattleBuild(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!canBattleBuild(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof Player)
            if (!canBattleBuild((Player) entity))
                event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (!canBattleBuild(event.getPlayer()))
            event.setCancelled(true);
    }

    private boolean canBattleBuild(Player player) {
        GameMode gamemode = player.getGameMode();
        boolean hasBuildPermission = player.hasPermission("hs.battle.build");

        if (player.getWorld() == Bukkit.getWorld("Battle"))
            if (gamemode != GameMode.CREATIVE || !hasBuildPermission)
                return false;
        return true;
    }
}