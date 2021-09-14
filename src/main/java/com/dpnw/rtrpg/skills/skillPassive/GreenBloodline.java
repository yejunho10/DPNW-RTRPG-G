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
public class GreenBloodline extends RPassive {
    private BukkitTask task;

    public GreenBloodline() {
        setDuration(5);
        setRank(Rank.UNCOMMON);
        setVisible(true);
        setSkillName(SkillName.GREEN_BLOODLINE);
    }

    public GreenBloodline(Player p) {
        setDuration(5);
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.GREEN_BLOODLINE);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getEnemyCount().containsKey(MobName.GOBLIN)) {
                if(cp.getEnemyCount().get(MobName.GOBLIN) > 50) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "몬스터 고블린을 50 마리 처치했다.";
    }

    @Override
    public void use(RPlayer p) {

    }


    @Override
    public void cancel() {
    }
}