package com.dpnw.rtrpg.schedulers;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.particles.ParticleUtil;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashSet;
import java.util.Set;

public class SpawnerShowScheduler {
    private static BukkitTask task;
    public static BukkitTask removeTask;
    private static final Set<ArmorStand> markers = new HashSet<>();

    public static void init() {
        removeTask = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> Bukkit.getWorld("world").getEntities().forEach(o -> {
            if(o instanceof ArmorStand) {
                if(o.getCustomName().contains("스포너")) {
                    o.remove();
                }
            }
        }), 0L, 5L);
    }

    public static void off() {
        try {
            task.cancel();
            markers.forEach(Entity::remove);
            markers.clear();
        } catch (Exception ignored) {
        }
    }

    public static void show() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            markers.forEach(Entity::remove);
            markers.clear();
            for (MythicSpawner s : MythicMobs.inst().getSpawnerManager().getSpawners()) {
                World w = Bukkit.getWorld(s.getWorldName());
                double x = s.getLocation().getX();
                double y = s.getLocation().getY();
                double z = s.getLocation().getZ();
                Location loc = new Location(w, x, y, z);
                Location loc2 = loc.clone().add(0, 20, 0);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.isOp()) continue;
                    Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> ParticleUtil.line(loc, loc2, 0.3, Particle.FLAME, 0, 0, 0, 2, 0));
                }
                String spawnerName = s.getInternalName();
                ArmorStand as = (ArmorStand) loc2.getWorld().spawnEntity(loc2, EntityType.ARMOR_STAND);
                as.setMarker(true);
                as.setCustomNameVisible(true);
                as.setCustomName("스포너 : " + spawnerName);
                markers.add(as);
            }
        }, 0L, 5L);
    }


}
