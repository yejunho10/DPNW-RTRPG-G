package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.entity.Player;

/*
Unlock : 공중에 5초 이상 떠 있었다.

Use : 시전 즉시 지면으로 낙하하며 주변의 모든 적에게 110 +(Lv * 5)의 피해를 준다. 공중에서만 사용 가능.

Damage : 110 +(Lv * 5)
Range : 7
Reqire mana : 35
Cooldown : 2
Rank : Uncommon
Visible : false
 */
public class MeteorStrike extends RActive {
    public MeteorStrike() {
        setCooldown(2);
        setDamage(110);
        setRank(Rank.UNCOMMON);
        setRequireMana(35);
        setVisible(false);
        setSkillName(SkillName.METEOR_STRIKE);
    }

    @Override
    public String skillUnlockCondition() {
        return "공중에 5초 이상 떠 있었다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        if (p.getPlayer().isOnGround()) return;
        p.getPlayer().setVelocity(p.getPlayer().getVelocity().setY(0.5));
        p.getPlayer().getNearbyEntities(7, 7, 7).forEach(e -> {
            if (!(e instanceof Player player)) return;
            player.damage(getDamage() + p.getLevel() * 5);
        });
        cooldown(this);
    }


    @Override
    public void cancel() {

    }
}
