package com.dpnw.rtrpg.events.damage;

import com.darksoldier1404.dppc.utils.Tuple;
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
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class EnemyGetDamaged implements Listener {
    private final Map<UUID, Map<SkillName, BukkitTask>> skillTasks = new HashMap<>();
    private final Map<UUID, Integer> attack3Times = new HashMap<>();

    @EventHandler
    public void onEnemyGetDamaged(SkillDamageEvent e) {
        LivingEntity le = (LivingEntity) e.getTarget();
        Player p = e.getPlayer();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        try {
            if (!RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) return;
            RMob mob = RTRPG.getInstance().rmobs.get(le.getUniqueId());
            mob.setCurrentHealth(mob.getCurrentHealth() - (e.getDamage() - mob.getCurrentArmor()));
            attack3Times.put(p.getUniqueId(), attack3Times.getOrDefault(p.getUniqueId(), 0) + 1);
            if(attack3Times.get(p.getUniqueId()) >= 3) {
                if(cp.getEquipedPassiveSkill().containsValue(SkillName.OVERHEATING)) {
                    mob.setCurrentHealth(mob.getCurrentHealth() - (AllSkills.getSkillFromName(SkillName.OVERHEATING).getDamage() - mob.getCurrentArmor()));
                }
                attack3Times.put(p.getUniqueId(), 0);
            }
            if (mob.getCurrentHealth() <= 0) {
                le.setKiller(p);
                le.setLastDamageCause(new EntityDamageEvent(p, EntityDamageEvent.DamageCause.CUSTOM, e.getDamage()));
                le.getPassengers().forEach(Entity::remove);
                le.setHealth(0);
                if (cp.getEquipedPassiveSkill().containsValue(SkillName.DELIGHT_OF_SLAUGHTER)) {
                    cp.setcurrentHealth(cp.getcurrentHealth() + 100 + cp.getLevel() * 3);
                }
                return;
            }
        } catch (Exception ignored) {
        }
        RMobUtil.setBar(e.getTarget());
    }


    @EventHandler
    public void onDamageByProjectile(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Mob m)) return;
        if (e.getDamager() instanceof Arrow ar) {
            e.setCancelled(true);
            if (ar.getShooter() instanceof Player p) {
                if (ar.hasMetadata("skill")) {
                    SkillName sn = SkillName.valueOf(ar.getMetadata("skill").get(0).asString());
                    if (sn.equals(SkillName.WATER_BALL)) {
                        Skill s = AllSkills.getSkillFromName(sn);
                        Bukkit.getServer().getPluginManager().callEvent(new SkillDamageEvent(s, p, m, e.getDamage()));
                    }
                    if (sn.equals(SkillName.FIRE_BALL)) {
                        Skill s = AllSkills.getSkillFromName(sn);
                        Bukkit.getServer().getPluginManager().callEvent(new SkillDamageEvent(s, p, m, e.getDamage()));
                    }
                }
            }
        }
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player p) {
            e.setCancelled(true);
            if (e.getEntity() instanceof Mob) {
                LivingEntity le = (LivingEntity) e.getEntity();
                CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
                try {
                    if (!RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) return;
                    RMob mob = RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.setCurrentHealth(mob.getCurrentHealth() - (e.getDamage() - mob.getCurrentArmor()));
                    if(attack3Times.get(p.getUniqueId()) >= 3) {
                        if(cp.getEquipedPassiveSkill().containsValue(SkillName.OVERHEATING)) {
                            mob.setCurrentHealth(mob.getCurrentHealth() - (AllSkills.getSkillFromName(SkillName.OVERHEATING).getDamage() - mob.getCurrentArmor()));
                        }
                        attack3Times.put(p.getUniqueId(), 0);
                    }
                    if (mob.getCurrentHealth() <= 0) {
                        le.setKiller(p);
                        le.setLastDamageCause(new EntityDamageEvent(e.getDamager(), EntityDamageEvent.DamageCause.CUSTOM, e.getDamage()));
                        le.getPassengers().forEach(Entity::remove);
                        le.setHealth(0);
                        passiveSkillUse(cp, mob, le);
                        return;
                    }
                    RMobUtil.setBar(e.getEntity());
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    public void passiveSkillUse(CraftRPlayer cp, RMob mob, LivingEntity le) {
        if (!skillTasks.containsKey(cp.getUUID())) {
            skillTasks.put(cp.getUUID(), new HashMap<>());
        }
        cp.getEquipedPassiveSkill().values().forEach(sn -> {
            switch (sn) {
                case DELIGHT_OF_SLAUGHTER:
                    mob.setCurrentHealth(mob.getCurrentHealth() - 100 + cp.getLevel() * 3);
                    break;
                case GREEN_BLOODLINE:
                    //기본공격 적중시 초당 피해 1 +(레벨당 1)의 피해를 5초간 입힌다.
                    skillTasks.get(cp.getUUID()).put(sn,
                            Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
                                mob.setCurrentHealth(mob.getCurrentHealth() - (1 + cp.getLevel() - mob.getCurrentArmor()));
                            }, 0, 5 * 20)
                    );
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                        skillTasks.get(cp.getUUID()).get(sn).cancel();
                        skillTasks.get(cp.getUUID()).remove(sn);
                    }, 5 * 20);

            }
        });
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
