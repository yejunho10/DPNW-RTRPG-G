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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class SpawnerShowScheduler {
    private static BukkitTask task;

    public static void off() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }

    public static void show() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            for (MythicSpawner s : MythicMobs.inst().getSpawnerManager().getSpawners()) {
                World w = Bukkit.getWorld("world");
                double x = s.getLocation().getX();
                double y = s.getLocation().getY();
                double z = s.getLocation().getZ();
                Location loc = new Location(w, x, y, z);
                Location loc2 = new Location(w, x, y + 20, z);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.isOp()) continue;
                    Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> ParticleUtil.line(loc, loc2, 0.2, Particle.FLAME, 0, 0, 0, 3, 0));
                }
                String spawnerName = s.getInternalName();

                ArmorStand as = loc2.getWorld().spawn(loc2, ArmorStand.class);
                as.setGravity(false);
                as.setMarker(true);
                as.setCustomNameVisible(true);
                as.setCustomName(spawnerName);
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), as::remove, 5L);
            }
        }, 0L, 5L);
    }

//    public static void sendParticle(Player p, double x, double y, double z) {
//        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(Particles.C, true, x, y, z, 0, 0, 0, 0, 3);
//        ((CraftPlayer) p).getHandle().b.sendPacket(packet);
//    }


}
