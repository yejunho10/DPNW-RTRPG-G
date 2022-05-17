package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Bukkit;

/*
Unlock : 1% 이하의 체력을 남기고 살아남았다.

Effect : 죽음에 이르는 공격을 받았을 때 4초간 무적 상태가 됩니다.

Cooldown : 250Secs
Rank : Uncommon
Viasble : false
 */
public class Mementomori extends RPassive {
    public Mementomori() {
        setCooldown(250);
        setDuration(4);
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.MEMENTOMORI);
    }

    @Override
    public String skillUnlockCondition() {
        return "1% 이하의 체력을 남기고 살아남았다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.setInvincible(true);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> p.setInvincible(false), (long) (getDuration() * 20));
        cooldown(this);
    }

    @Override
    public void cancel() {

    }
}