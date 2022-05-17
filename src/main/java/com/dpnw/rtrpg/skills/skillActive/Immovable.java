package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
/*
Unlock : 10분 동안 몬스터를 공격하지 않고 맞기만 했다.

Use : 1분 동안 위치 이동에 저항이 생기며, 방어력이 50 +(레벨당 1)%만큼 상승한다.

Increase Armor : 50 +(1 for a lv)
Duration : 60Secs (1m)
Require Energy : 100
Cooldown : 180 (3m)
Rank : Uncommon
Visable : false
 */
public class Immovable extends RActive {

    public Immovable() {
        setIncreaseArmor(50);
        setDuration(60);
        setCooldown(180);
        setRank(Rank.UNCOMMON);
        setRequireMana(100);
        setVisible(false);
        setSkillName(SkillName.IMMOVABLE);
    }

    @Override
    public String skillUnlockCondition() {
        return "10분 동안 몬스터를 공격하지 않고 맞기만 했다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        //todo logic...
        cooldown(this);
    }

    @Override
    public void cancel() {

    }
}