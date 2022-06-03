package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;

/*
Unlock : 전쟁의 외침을 50번 사용했다.

Use : 시전시 자신의 위치에 말뚝을 소환합니다. 말뚝은 약 3초뒤 활성화되며 주변 범위 내의 모든 적들을 5초간 끌어당기고 초당 57 +(레벨당 3)의 피해를 입힙니다.

Damage for a tick : 57 +(3 for a lv)
Range : 12
Duration : 2
Require mana : 60
Rank : Common
Visible : true
 */
public class Punishment extends RActive {
    public Punishment() {
        setRank(Rank.COMMON);
        setDamage(57);
        setRange(12);
        setDuration(2);
        setRequireMana(60);
        setVisible(true);
        setSkillName(SkillName.PUNISHMENT);
    }

    @Override
    public void use(RPlayer p) {

    }

    @Override
    public String skillUnlockCondition() {
        return "전쟁의 외침을 50번 사용했다.";
    }

    @Override
    public void cancel() {
    }
}
