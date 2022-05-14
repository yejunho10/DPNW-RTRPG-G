package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
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
Unlock : 10마리의 적을 처치했다.

Effect : 방어력이 15 +(레벨당 1) 증가합니다.

Rank : Common
Visible : true
 */
@SuppressWarnings("unused")
public class Resolution extends RPassive {
    private BukkitTask task;

    public Resolution(RPlayer rp) {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.RESOLUTION);
        setIncreaseArmor(15 + rp.getLevel());
    }

    public Resolution(Player p) {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.RESOLUTION);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        setIncreaseArmor(15 + cp.getLevel());
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (cp.getKillCount() >= 10) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "10마리의 적을 처치했다.";
    }

    @Override
    public void use(RPlayer p) {

    }


    @Override
    public void cancel() {
    }
}