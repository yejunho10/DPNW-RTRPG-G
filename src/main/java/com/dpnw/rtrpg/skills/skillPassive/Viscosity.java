package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
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
Unlock : 슬라임을 50회 처치했다.

Effect : 피격시 공격자의 공격속도와 공격력이 10% 감소한다.

Rank : Common
Visible : false
 */
@SuppressWarnings("unused")
public class Viscosity extends RPassive { // todo 공격속도 필드 추가
    private BukkitTask task;

    public Viscosity() {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.VISCOSITY);
        setDecreaseWeaponDamagePercent(10);
    }

    public Viscosity(Player p) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.VISCOSITY);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getEnemyCount().containsKey(MobName.SLIME)) {
                if (cp.getEnemyCount().get(MobName.SLIME) > 50) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "슬라임을 50회 처치했다.";
    }


    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}