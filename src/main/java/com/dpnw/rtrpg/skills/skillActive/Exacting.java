package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
/*
Unlock : 메인퀘스트 6 완료

Use : 다음 세번의 공격은 35% 감소한 피해를 입고, 공격한 적에게 25 +(방어력의 15%) 만큼의 피해를 줍니다.

Damage : 25 +(15% of Armor)
Number : 3
Decrease Damage : 35%
Cooldown : 8
Rank : Common
visible : true
 */
public class Exacting extends RActive {
    public int count;

    public Exacting() {
        setDamage(25);
        setCooldown(8);
        count = 3;
        setRank(Rank.COMMON);
        setIncreaseArmor(35);
        setVisible(true);
        setSkillName(SkillName.EXACTING);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 6 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        count = 3;
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
