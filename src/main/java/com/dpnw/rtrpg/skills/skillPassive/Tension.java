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


@SuppressWarnings("unused")
public class Tension extends RPassive {
    private BukkitTask task;

    public Tension() {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.TENSION);
    }

    public Tension(Player p) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.TENSION);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getEnemyCount().containsKey(MobName.WATER_SLIME)) {
                if(cp.getEnemyCount().get(MobName.WATER_SLIME) > 50) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "워터 슬라임을 50회 처치했다.";
    }

    @Override
    public void use(RPlayer p) {

    }


    @Override
    public void cancel() {
    }
}