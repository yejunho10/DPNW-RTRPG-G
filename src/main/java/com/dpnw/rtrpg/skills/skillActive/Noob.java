package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.entity.Player;
/*
Unlock : 되살아나고 1분 이내에 다시 죽었을 시.

Effect : 화면에 거대하게 타이틀로 "개허접" 이라고 뜬다.

Cooldown : 600sec.
Require mana : 1
Rank : Uncommon
Visable : false
 */
public class Noob extends RActive {

    public Noob() {
        setCooldown(600);
        setRank(Rank.UNCOMMON);
        setRequireMana(1);
        setVisible(false);
        setSkillName(SkillName.NOOB);
    }

    @Override
    public String skillUnlockCondition() {
        return "되살아나고 1분 이내에 다시 죽었을 시";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().sendTitle("개 허접", "개 허접이시뉑~~~");
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {

    }
}