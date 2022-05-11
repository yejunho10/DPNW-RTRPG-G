package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;

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
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
    }
}
