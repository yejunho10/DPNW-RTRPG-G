package com.dpnw.rtrpg.skills.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.skillActive.Noob;
import com.dpnw.rtrpg.skills.skillPassive.Thanatophobia;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DeathCount implements Listener {
    private final Set<UUID> dead = new HashSet<>(); //버그성 죽음 방지 (Ex: 0.1초만에 여러번 죽어버리는 버그
    private final Set<UUID> noob = new HashSet<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (dead.contains(p.getUniqueId())) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp == null) return;
        cp.setDeathCount(cp.getDeathCount() + 1);
        dead.add(cp.getUUID());
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> dead.remove(cp.getUUID()), 20L);
        //타나토포비아
        if (!RPlayerUtil.hasSkill(cp.getUUID(), SkillName.THANATOPHOBIA)) {
            if (cp.getDeathCount() >= 1000) {
                cp.getUnLockedSkills().add(SkillName.THANATOPHOBIA);
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new Thanatophobia(), p));
            }
        }
    }

    @EventHandler
    public void onNoob(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (noob.contains(p.getUniqueId())) {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (!RPlayerUtil.hasSkill(p.getUniqueId(), SkillName.NOOB)) {
                cp.getUnLockedSkills().add(SkillName.NOOB);
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new Noob(), p));
            }
        } else {
            noob.add(p.getUniqueId());
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> noob.remove(p.getUniqueId()), 60 * 20L);
        }
    }
}