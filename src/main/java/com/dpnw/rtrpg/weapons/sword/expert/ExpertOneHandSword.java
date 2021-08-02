package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class ExpertOneHandSword extends Sword {

    public ExpertOneHandSword() {
        setWeaponName(WeaponName.EXPERT_ONE_HAND_SWORD);
        setDisplayName("숙련자의 한손검");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(44);
        setAttackSpeed(1.2);
        setCriticalChance(30);
        setCriticalDamage(1.25);
        setMaxMana(35);
        setRange(2);
        setHealthRegen(0.4);
        setAngle(90);
    }


}
