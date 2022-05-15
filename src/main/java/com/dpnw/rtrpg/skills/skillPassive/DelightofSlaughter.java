package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 1000마리 이상의 적을 처치했다.

Effect : 적 처치시 100 +(레벨당 3)의 체력을 회복한다.

Healing : 100 +(3 for a lv)
Rank : Rare
Visible : true
 */
@SuppressWarnings("unused")
public class DelightofSlaughter extends RPassive {
    private BukkitTask task;

    public DelightofSlaughter() {
        setRank(Rank.RARE);
        setVisible(true);
        setSkillName(SkillName.DELIGHT_OF_SLAUGHTER);
    }

    public DelightofSlaughter(Player p) {
        setRank(Rank.RARE);
        setVisible(true);
        setSkillName(SkillName.DELIGHT_OF_SLAUGHTER);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getKillCount() >= 1000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "1000마리의 적을 처치했다.";
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            task = null;
        } catch (Exception ignored) {
        }
    }
}