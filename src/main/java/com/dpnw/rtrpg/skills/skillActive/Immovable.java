package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;

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
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {

    }
}