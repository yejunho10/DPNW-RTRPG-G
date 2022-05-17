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
Unlock : 워터 슬라임을 50회 처치했다.

Effect : 최대 체력인 상태에서 5초간 피격 당하지 않으면 전체 체력의 2 +(레벨당  0.03)%의 피해를 흡수하는 보호막을 생성한다.

Rank : Common
Visible : false
 */
@SuppressWarnings("unused")
public class Tension extends RPassive { // todo 쉴드 로직 제작
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