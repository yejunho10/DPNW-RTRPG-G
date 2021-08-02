package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class ExpertKnife extends Sword {

    public ExpertKnife() {
        setWeaponName(WeaponName.EXPERT_KNIFE);
        setDisplayName("숙련자의 단도");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(37);
        setAttackSpeed(1.5);
        setCriticalChance(45);
        setCriticalDamage(2);
        setHealth(25);
        setMaxMana(35);
        setDodgeChance(8);
        setMovementSpeed(0.3);
        setRange(2);
        setAngle(90);
    }


}
