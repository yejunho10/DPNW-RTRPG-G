package com.dpnw.rtrpg.events.damage;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.skillActive.Exacting;
import com.dpnw.rtrpg.skills.skillActive.MemoryOfFeet;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class PlayerGetDamaged implements Listener {
    private final Set<UUID> alreadyDead = new HashSet<>();
    private final Set<UUID> alreadyAttacked = new HashSet<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (alreadyDead.contains(e.getEntity().getUniqueId())) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getEntity().getUniqueId());
        cp.setDeathCount(cp.getDeathCount() + 1);
        alreadyDead.add(cp.getUUID());
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> alreadyDead.remove(cp.getUUID()), 10L);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()) <= 0) {
            p.setHealth(0);
        } else {
            cp.setcurrentHealth(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()));
            setHealthScale(cp);
            p.setHealth(cp.getcurrentHealth());
        }

        for (SkillName sn : cp.getEquipedActiveSkill().values()) {
            if (sn == SkillName.MEMORY_OF_FEET) {
                MemoryOfFeet skill = (MemoryOfFeet) cp.getActiveList().get(sn);
                if (skill.isReady()) {
                    skill.cancelByAttacked();
                }
            }
            if(sn == SkillName.EXACTING) {
                Exacting skill = (Exacting) cp.getActiveList().get(sn);
                if(skill.count != 0) {
                    skill.count -= 1;
                    e.setDamage(0);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerGetDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        e.setCancelled(true);
        if (RTRPG.getInstance().rmobs.containsKey(e.getDamager().getUniqueId())) {
            CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(e.getDamager().getUniqueId());
            if (alreadyAttacked.contains(mob.getUUID())) return;
            alreadyAttacked.add(mob.getUUID());
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> alreadyAttacked.remove(mob.getUUID()), (long) (mob.getAttackSpeed() * 20L));
        }
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());

        if (cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()) <= 0) {
            p.setHealth(0);
        } else {
            cp.setcurrentHealth(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()));
            setHealthScale(cp);
            p.setHealth(cp.getcurrentHealth());
        }
        e.setCancelled(true);
    }

    private void setHealthScale(CraftRPlayer rp) {
        Player p = rp.getPlayer();
        p.setHealth(rp.getcurrentHealth() / (rp.getHealth() / 20));


        // ~~` * 1/100
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player p) {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if(cp.getEquipedPassiveSkill().containsValue(SkillName.HUG_OF_WIND)){
                Random rand = new Random();
                int n = rand.nextInt(100);
                int r = (int) (8 + (cp.getLevel() * 0.07));
                if(n >= r) {
                    e.setCancelled(true);
                }
            }
            if(cp.getcurrentHealth() - e.getDamage() <= 0) {
                if(cp.getEquipedPassiveSkill().containsValue(SkillName.MEMENTOMORI)){
                    cp.getPassiveList().get(SkillName.MEMENTOMORI).use(cp);
                }
            }
        }
    }
}