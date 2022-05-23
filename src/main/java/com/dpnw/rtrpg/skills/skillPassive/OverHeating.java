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
Unlock : 마그마 슬라임을 50회 처치했다.

Effect : 매 세번째 공격이 적중할 떄마다 27 + (레벨당 3)의 추가 피해를 준다. 마나가 가득차 있는 상태면 이 피해는 두배가 된다.

Damage : 27 +(3 for a lv)
Rank : Common
Visible : false
 */
@SuppressWarnings("unused")
public class OverHeating extends RPassive {
    private BukkitTask task;

    public OverHeating(RPlayer rp) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.OVERHEATING);
        setDamage(27 + rp.getLevel() * 3);
    }

    public OverHeating() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.OVERHEATING);
        setDamage(27 + 3);
    }

    public OverHeating(Player p) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.OVERHEATING);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        setDamage(27 + cp.getLevel() * 3);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (cp.getEnemyCount().containsKey(MobName.MAGMA_SLIME)) {
                if (cp.getEnemyCount().get(MobName.MAGMA_SLIME) > 50) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "마그마 슬라임을 50회 처치했다.";
    }

    @Override
    public void cancel() {
    }
}