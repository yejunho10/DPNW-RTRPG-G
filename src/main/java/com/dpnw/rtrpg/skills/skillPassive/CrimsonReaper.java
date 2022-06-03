package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.entity.Player;

/*
[패시브] 진홍빛 사신 (Crimson Reaper)
Unlock : 피의 신자 종 500마리 처치

Effect : 생명력 흡수 10% 증가 피의 신자 종 몬스터들과 상호작용 불가,
         기본 공격이 2번 적중하면 다음 2초간 치명타율 100%,
         지속시간 동안 기본공격으로 입힌 피해의 50%만큼 체력 회복

Duration : 2
Rank : Extra
Visible : false
Maximum having : 1

****기획자 똥 수듄****

*/
public class CrimsonReaper extends RPassive {
    public CrimsonReaper() {
        setRank(Rank.EXTRA);
        setDuration(2);
        setMaxHaving(1);
        setVisible(false);
        setSkillName(SkillName.CRIMSON_REAPER);
    }

    public CrimsonReaper(Player p) {
        setRank(Rank.EXTRA);
        setDuration(2);
        setMaxHaving(1);
        setVisible(false);
        setSkillName(SkillName.CRIMSON_REAPER);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
    }

    @Override
    public void cancel() {
    }

    @Override
    public String skillUnlockCondition() {
        return "피의 신자 종 500마리 처치";
    }
}
