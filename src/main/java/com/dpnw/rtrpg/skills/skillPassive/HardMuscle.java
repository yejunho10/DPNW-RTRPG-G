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
Unlock : 몬스터 "홉고블린"을 50마리 처치했다.

Effect : 입는 피해량이 2 +(레벨당 0.28)% 감소한다.

Rank : Uncommon
Visable : false
 */
@SuppressWarnings("unused")
public class HardMuscle extends RPassive {
    private BukkitTask task;

    public HardMuscle(RPlayer rp) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.HARD_MUSCLE);
        setIncreaseArmorPercent(2 + rp.getLevel() * 0.28);
    }

    public HardMuscle(Player p) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.HARD_MUSCLE);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        setIncreaseArmorPercent(2 + cp.getLevel() * 0.28);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (cp.getEnemyCount().containsKey(MobName.HOB_GOBLIN)) {
                if (cp.getEnemyCount().get(MobName.HOB_GOBLIN) > 50) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "몬스터 홉고블린을 50 마리 처치했다.";
    }

    @Override
    public void use(RPlayer p) {

    }


    @Override
    public void cancel() {
    }
}