package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
/*
Unlock : 15000 블럭 이상을 이동했다.

Effect : 8 +(레벨당 0.07) 확률로 피해를 무효화 합니다.

Rank : Common
Visable : false
 */
public class HugOfWind extends RPassive {
    private BukkitTask task;

    public HugOfWind() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.HUG_OF_WIND);
    }

    public HugOfWind(Player p) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.HUG_OF_WIND);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer)RPlayerUtil.getRPlayer(p.getUniqueId());
            if(cp == null) return;
            if (cp.getMoveCount() >= 15000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 10L, 20L);
    }

    @Override
    public void cancel() {
        try{
            task.cancel();
        }catch (Exception ignored){}
    }


    @Override
    public String skillUnlockCondition() {
        return "15000 블럭 이상을 이동했다.";
    }
}