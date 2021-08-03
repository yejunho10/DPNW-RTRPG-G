package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.mob.obj.RMob;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillDamageEvent;
import com.dpnw.rtrpg.utils.RMobUtil;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;

public class EnemyGetDamaged implements Listener {

    @EventHandler
    public void onEnemyGetDamaged(SkillDamageEvent e) {
        RMobUtil.setBar(e.getTarget());
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            if (e.getEntity() instanceof Mob) {
                LivingEntity le = (LivingEntity) e.getEntity();
                try {
                    RMob mob = RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.setCurrentHealth(le.getHealth() - (e.getDamage() - mob.getCurrentArmor()));
                    RMobUtil.setBar(e.getEntity());
                } catch (Exception ignored) {
                }
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void damageCounter(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Mob) {
            Entity vic = e.getEntity();
            Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
                Random rd = new Random();
                Location loc = vic.getLocation();
                loc.add(-0.5 + rd.nextDouble(), 2, -0.5 + rd.nextDouble());
                Item as = vic.getWorld().dropItem(loc, new ItemStack(Material.MUSIC_DISC_11));
                as.setCustomName("§f" + (int) e.getDamage());
                as.setCustomNameVisible(true);
                as.setVelocity(new Vector(0, 0.2, 0));
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), as::remove, 10L);
            });
        }
    }

    @EventHandler
    public void onEnemyKilled(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Mob m)) return;
        if (e.getEntity().getKiller() == null) return;
        if (!RTRPG.getInstance().rmobs.containsKey(m.getUniqueId())) return;
        System.out.println("1");
        Player p = e.getEntity().getKiller();
        MobName mn = RTRPG.getInstance().rmobs.get(m.getUniqueId()).getMobName();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        try {
            System.out.println("2");
            cp.getEnemyCount().put(mn, cp.getEnemyCount().get(mn) + 1);
            for (Entity mob : m.getPassengers()) { //remove bar
                mob.remove();
                System.out.println("3");
            }
        } catch (Exception ee) {
            System.out.println("ee");
            for (Entity mob : m.getPassengers()) { //remove bar
                mob.remove();
                System.out.println("3");
            }
            cp.getEnemyCount().put(mn, 1);
        }
    }
}
