package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class RMobUtil {

    public static void setBar(Entity e) {
        try {
            if (e.isDead()) return;
            LivingEntity le = (LivingEntity) e;
            if (le.getPassengers().size() >= 1) {
                e.getPassengers().get(0).setCustomName(getStr(RTRPG.getInstance().rmobs.get(e.getUniqueId()).getCurrentHealth()));
                return;
            }
            Item healthbar = le.getWorld().dropItem(e.getLocation(), new ItemStack(Material.MUSIC_DISC_PIGSTEP));
            healthbar.setGravity(false);
            healthbar.setInvulnerable(true);
            healthbar.setCustomName(getStr(RTRPG.getInstance().rmobs.get(e.getUniqueId()).getCurrentHealth()));
            healthbar.setCustomNameVisible(true);
            le.addPassenger(healthbar);
            le.setCustomNameVisible(false);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static String getStr(double hp) {
        StringBuilder s = new StringBuilder("§eHP : §4");
        String shp = String.format("%.1f", hp);
        char[] chp = shp.toCharArray();
        for (char c : chp) {
            if (c == '0') {
                s.append("");
            }
            if (c == '1') {
                s.append("");
            }
            if (c == '2') {
                s.append("");
            }
            if (c == '3') {
                s.append("");
            }
            if (c == '4') {
                s.append("");
            }
            if (c == '5') {
                s.append("");
            }
            if (c == '6') {
                s.append("");
            }
            if (c == '7') {
                s.append("");
            }
            if (c == '8') {
                s.append("");
            }
            if (c == '9') {
                s.append("");
            }
            if (c == '.') {
                s.append(c);
            }
        }
        return s.toString();
    }

    @Nullable
    public static Entity getNearestEntity(Location loc, double range) {
        Entity nearest = null;
        double distance = range;
        for (Entity e : loc.getWorld().getEntities()) {
            if (e.getLocation().distance(loc) < distance) {
                nearest = e;
                distance = e.getLocation().distance(loc);
            }
        }
        return nearest;
    }

    @Nullable
    public static LivingEntity getNearestLivingEntity(Location loc, double range) {
        LivingEntity nearest = null;
        double distance = range;
        for (Entity e : loc.getWorld().getEntities()) {
            if (e.getLocation().distance(loc) < distance && e instanceof LivingEntity) {
                nearest = (LivingEntity) e;
                distance = e.getLocation().distance(loc);
            }
        }
        return nearest;
    }
}
