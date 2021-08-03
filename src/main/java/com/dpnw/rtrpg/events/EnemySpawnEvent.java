package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.mob.*;
import com.dpnw.rtrpg.utils.RMobUtil;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EnemySpawnEvent implements Listener {

    @EventHandler
    public void onEnemySpawn(final MythicMobSpawnEvent e) {
        e.getEntity().setCustomNameVisible(true);
        try {
            if (e.getMob().getType().getInternalName().contains("치킨")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Chicken(e.getMob())), 2L);
            }
            if (e.getMob().getType().getInternalName().contains("슬라임")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Slime(e.getMob())), 2L);
            }
            if (e.getMob().getType().getInternalName().contains("워터슬라임")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new WaterSlime(e.getMob())), 2L);
            }
            if (e.getMob().getType().getInternalName().contains("마그마슬라임")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new MagmaSlime(e.getMob())), 2L);
            }
            if (e.getMob().getType().getInternalName().contains("킹슬라임")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new KingSlime(e.getMob())), 2L);
            }
            if (e.getMob().getType().getInternalName().contains("고블린")) {
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Goblin(e.getMob())), 2L);
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        e.getEntity().setCustomNameVisible(true);
    }
}
