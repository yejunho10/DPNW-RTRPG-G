package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.particles.ParticleUtil;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RMobUtil {

    public static void setBar(Entity e) {
        try {
            if (e.isDead()) return;
            LivingEntity le = (LivingEntity) e;
            if (le.getPassengers().size() >= 1) {
                System.out.println(e.getPassengers().get(0).getCustomName());
                e.getPassengers().get(0).setCustomName(getStr(RTRPG.getInstance().rmobs.get(e.getUniqueId()).getCurrentHealth()));
                return;
            }
            System.out.println("add passenger");
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

//        String before = ChatColor.of("#3162C7") + "";
//		String after = ChatColor.of("#5D5D5D") + "";
//		s+= "";
//        s.append(" §f/ ").append(before);
//        for (char c : cshield) {
//            if (c == '0') {
//                s.append("");
//            }
//            if (c == '1') {
//                s.append("");
//            }
//            if (c == '2') {
//                s.append("");
//            }
//            if (c == '3') {
//                s.append("");
//            }
//            if (c == '4') {
//                s.append("");
//            }
//            if (c == '5') {
//                s.append("");
//            }
//            if (c == '6') {
//                s.append("");
//            }
//            if (c == '7') {
//                s.append("");
//            }
//            if (c == '8') {
//                s.append("");
//            }
//            if (c == '9') {
//                s.append("");
//            }
//        }
//		if (hp <= 0) {
//			return s;
//		} else {
//			int per = (int) (hp * 100 / mhp);
//			int count = (int) (per * 10 / 10);
//			char c = '';
//
//			int i = 0;
//			for (i = 0; i <= count; i++) {
//				s += c;
//			}
//			s += after;
//			while (i <= 100) {
//				i++;
//				s += c;
//			}
//		}
        return s.toString();
    }

    public static void saveSpawners() {
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
        }
    }
}
