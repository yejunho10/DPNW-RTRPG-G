package com.dpnw.rtrpg.events.damage;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.mob.obj.RMob;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillDamageEvent;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.utils.RMobUtil;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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
    public void onDamageByProjectile(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof Mob m)) return;
        if(e.getDamager() instanceof Arrow ar) {
            e.setCancelled(true);
            if(ar.getShooter() instanceof Player p) {
                if(ar.hasMetadata("skill")) {
                    SkillName sn = SkillName.valueOf(ar.getMetadata("skill").toString());
                    if(sn.equals(SkillName.WATER_BALL)) {
                        Skill s = AllSkills.getSkillFromName(sn);
                        Bukkit.getServer().getPluginManager().callEvent(new SkillDamageEvent(s, p, m, e.getDamage()));
                    }
                }
            }
        }
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            e.setCancelled(true);
            if (e.getEntity() instanceof Mob) {
                LivingEntity le = (LivingEntity) e.getEntity();
                try {
                    if (!RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) return;
                    RMob mob = RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.setCurrentHealth(mob.getCurrentHealth() - (e.getDamage() - mob.getCurrentArmor()));
                    if (mob.getCurrentHealth() <= 0) {
                        le.setKiller((Player) e.getDamager());
                        le.setLastDamageCause(new EntityDamageEvent(e.getDamager(), EntityDamageEvent.DamageCause.CUSTOM, e.getDamage()));
                        le.getPassengers().forEach(Entity::remove);
                        le.setHealth(0);
                        return;
                    }
                    RMobUtil.setBar(e.getEntity());
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void damageCounter(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Mob) {
            e.setCancelled(true);
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
        if (!(e.getEntity() instanceof Mob m)) {
            System.out.println("dead entity is not a mob");
            return;
        }
        if (e.getEntity().getKiller() == null) {
            System.out.println("killer is null");
            return;
        }
        if (!RTRPG.getInstance().rmobs.containsKey(e.getEntity().getUniqueId())) {
            System.out.println("this mob is not include in rmobs array");
            return;
        }
        Player p = e.getEntity().getKiller();
        CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(m.getUniqueId());
        MobName mn = rmob.getMobName();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        try {
            cp.getEnemyCount().put(mn, cp.getEnemyCount().get(mn) + 1);
            cp.setKillCount(cp.getKillCount() + 1);
            for (Entity mob : m.getPassengers()) { //remove bar
                mob.remove();
            }
            if (!(rmob.getExp() == 0)) {
                cp.giveExp(rmob.getExp());
            }
            System.out.println(mn.getKor() + "killed by : " + cp.getPlayer().getName());
            System.out.println("recived exp : " + rmob.getExp());
            RTRPG.getInstance().rmobs.remove(m.getUniqueId());
        } catch (Exception ee) {
            for (Entity mob : m.getPassengers()) { //remove bar
                mob.remove();
            }
            cp.getEnemyCount().put(mn, 1);
            cp.setKillCount(cp.getKillCount() + 1);
            RTRPG.getInstance().rmobs.remove(m.getUniqueId());
        }
    }
}
