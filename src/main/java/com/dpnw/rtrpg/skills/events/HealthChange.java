package com.dpnw.rtrpg.skills.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.skillActive.Turtle;
import com.dpnw.rtrpg.skills.skillPassive.Mementomori;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings("all")
public class HealthChange implements Listener {
    private final Set<UUID> in = new HashSet<>(); //메멘토모리
    private final Set<UUID> noAttack = new HashSet<>(); //요지부동
    //메멘토모리
    @EventHandler
    public void onHealthChanged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp == null) return;
        double chp = cp.getcurrentHealth();
        //사용
        if (RPlayerUtil.hasSkill(cp.getUUID(), SkillName.MEMENTOMORI)) {
            if (chp <= e.getDamage()) {
                cp.getPassiveList().get(SkillName.MEMENTOMORI).use(cp);
                return;
            }
        }else {
            //조건
            double mhp = cp.getHealth();
            if (mhp * 0.01 >= chp) {
                in.add(cp.getUUID());
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                    if (!in.contains(cp.getUUID())) return;
                    in.remove(cp.getUUID());
                    cp.getUnLockedSkills().add(SkillName.MEMENTOMORI);
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new Mementomori(), p));
                }, 60L);
            }
        }
        //요지부동

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        in.remove(p.getUniqueId());
        ((CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId())).setT_Damaged(0);
    }

    @EventHandler
    public void onDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp == null) return;
        if (!RPlayerUtil.hasSkill(cp.getUUID(), SkillName.TURTLE)) {
            cp.setT_Damaged(cp.getT_Damaged() + 1);
            if (cp.getT_Damaged() >= 100) {
                cp.getUnLockedSkills().add(SkillName.TURTLE);
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new Turtle(), p));
            }
        }
        if (!RPlayerUtil.hasSkill(cp.getUUID(), SkillName.IMMOVABLE)) {
            cp.setT_noAttack(cp.getT_noAttack() + 1);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp == null) return;
        cp.setT_noAttack(0);
    }
}