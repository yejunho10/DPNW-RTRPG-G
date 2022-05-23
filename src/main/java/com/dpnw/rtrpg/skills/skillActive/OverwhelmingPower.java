package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

/*
[액티브] - 압도적인 힘 (Overwhelming Power) === 이벤트성 언락 조건을 가진 스킬
Unlock : 스킬로 공격력이 증가한 상태에서 적을 처치했다.

Use : 1분 동안 무기 공격력이 1.5배가 된다. 효과가 지속되는 동안 적을 처치할 때마다 지속시간이 10초 추가된다.

Duration : 60Secs (1m)
Cooldown : 300 (5m)
Require Mana : 85
Rank : Common
Visible : false
 */
@SuppressWarnings("all")
public class OverwhelmingPower extends RActive { // todo 데미지 로직에 값 추가
    private BukkitTask task;
    private int count;

    public OverwhelmingPower() {
        setDuration(60);
        setCooldown(300);
        setRequireMana(85);
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.OVERWHELMING_POWER);
    }

    @Override
    public String skillUnlockCondition() {
        return "스킬로 공격력이 증가한 상태에서 적을 처치했다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        count = 60;
        CraftRPlayer cp = (CraftRPlayer) rp;
        cp.setIncreaseWeaponDamage(cp.getIncreaseWeaponDamage() * 1.5);
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (count == 0) {
                task.cancel();
                return;
            }
            count--;
        }, 0, 20L);
        cooldown(this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
