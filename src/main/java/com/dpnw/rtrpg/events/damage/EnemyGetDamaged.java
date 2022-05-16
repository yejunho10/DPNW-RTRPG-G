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
    /*
    Effect : 기본공격 및 스킬 적중시 적에게 '죄' 스택이 쌓인다. 스택 1 당 시전자로부터 입는 피해가 1% 증가하며,
 최대 30스텍 까지 쌓을 수 있다. 최대 스택에 도달하면 이동 속도가 30%, 방어력이 30% 추가로 감소하며,
  대상이 사망할 때까지 매 초마다 55 +(레벨 X 0.1) 만큼의 피해를 준다. (대상이 플레이어면 미적용)
  단. 어그로가 풀리면 초기화 된다.
     */

    public void sin(CraftRPlayer rp, CraftRMob rmob, LivingEntity le) {
        if(rp.getEquipedPassiveSkill().containsValue(SkillName.SIN)) {

        }
    }

    @EventHandler
    public void onEnemyGetDamaged(SkillDamageEvent e) { // 스킬
        LivingEntity le = (LivingEntity) e.getTarget();
        Player p = e.getPlayer();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        try {
            if (!RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) return;
            CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
            mob.damage(e.getDamage(), p);
            attack3Times.put(p.getUniqueId(), attack3Times.getOrDefault(p.getUniqueId(), 0) + 1);
            if (attack3Times.get(p.getUniqueId()) >= 3) {
                if (cp.getEquipedPassiveSkill().containsValue(SkillName.OVERHEATING)) {
                    mob.damage(AllSkills.getSkillFromName(SkillName.OVERHEATING).getDamage(), p);
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
    public void onDamageByProjectile(EntityDamageByEntityEvent e) { // 투사체 -> 스킬
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
    public void onDamage(EntityDamageByEntityEvent e) { // 평타
        if (e.getDamager() instanceof Player p) {
            e.setCancelled(true);
            if (e.getEntity() instanceof Mob m) {
                LivingEntity le = (LivingEntity) e.getEntity();
                CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
                try {
                    if (!RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) return;
                    CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.damage(e.getDamage(), p);
                    if (attack3Times.get(p.getUniqueId()) >= 3) {
                        if (cp.getEquipedPassiveSkill().containsValue(SkillName.OVERHEATING)) {
                            mob.damage(AllSkills.getSkillFromName(SkillName.OVERHEATING).getDamage(), p);
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

    public void passiveSkillUse(CraftRPlayer cp, CraftRMob mob, LivingEntity le) { // when mob die
        if (!skillTasks.containsKey(cp.getUUID())) {
            skillTasks.put(cp.getUUID(), new HashMap<>());
        }
        cp.getEquipedPassiveSkill().values().forEach(sn -> {
            switch (sn) {
                case DELIGHT_OF_SLAUGHTER -> mob.damage(100 + cp.getLevel() * 3, cp.getPlayer());
                case GREEN_BLOODLINE -> {
                    //기본공격 적중시 초당 피해 1 +(레벨당 1)의 피해를 5초간 입힌다.
                    skillTasks.get(cp.getUUID()).put(sn,
                            Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
                                mob.damage(1 + cp.getLevel() - mob.getCurrentArmor(), cp.getPlayer());
                            }, 0, 5 * 20)
                    );
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                        skillTasks.get(cp.getUUID()).get(sn).cancel();
                        skillTasks.get(cp.getUUID()).remove(sn);
                    }, 5 * 20);
                }
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
