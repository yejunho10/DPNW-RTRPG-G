package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class ExpertSpear extends Sword {

    public ExpertSpear() {
        setWeaponName(WeaponName.EXPERT_SPEAR);
        setDisplayName("숙련자의 창");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(47);
        setAttackSpeed(0.8);
        setCriticalChance(35);
        setCriticalDamage(1.25);
        setHealth(45);
        setManaRegen(0.4);
        setRange(4);
        setReach(0.1);
        setAngle(10);
    }


}
