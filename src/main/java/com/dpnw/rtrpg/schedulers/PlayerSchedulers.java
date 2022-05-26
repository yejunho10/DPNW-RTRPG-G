package com.dpnw.rtrpg.schedulers;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.functions.MenuFunctions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

import java.util.*;

public class PlayerSchedulers {
    private final static RTRPG plugin = RTRPG.getInstance();
    private final static Set<UUID> shifted = new HashSet<>();
    private final static Set<UUID> unShifted = new HashSet<>();

    public static void initDetectDoubleShifting() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> Bukkit.getOnlinePlayers().forEach(o -> {
            shifted.remove(o.getUniqueId());
            unShifted.remove(o.getUniqueId());
        }), 0L, 15L);
        Bukkit.getScheduler().runTaskTimer(plugin, () -> Bukkit.getOnlinePlayers().forEach(o -> {
            if (o.isSneaking()) {
                if (shifted.contains(o.getUniqueId())) {
                    if (unShifted.contains(o.getUniqueId())) {
                        System.out.println("더블 쉬프트");
                        shifted.remove(o.getUniqueId());
                        unShifted.remove(o.getUniqueId());
                        return;
                    }
                }
                shifted.add(o.getUniqueId());
            } else {
                if (shifted.contains(o.getUniqueId())) {
                    unShifted.add(o.getUniqueId());
                }
            }
        }), 0L, 1L);
    }

    public static void initSlotSwap() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> Bukkit.getOnlinePlayers().forEach(o -> {
            if (o.getGameMode() == GameMode.SURVIVAL) {
                o.getInventory().setHeldItemSlot(8);
                o.setFoodLevel(20);
                MenuFunctions.updateSkillBar(o);
            }
        }), 0L, 3L);
    }

    public static void initArrowEffectTask() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> plugin.projectileList.forEach(o -> {
            Entity e = Bukkit.getEntity(o);
            Location loc = e.getLocation();
            loc.getWorld().spawnParticle(Particle.WATER_BUBBLE, loc, 10);
        }), 0L, 2L);
    }
}
