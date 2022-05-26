package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeKnife extends DualSword {
    public ApprienticeKnife() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(25);
        setDefaultWeaponAttackSpeed(1.4);
        setDefaultWeaponCritChance(40);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(20);
        setDodgeChance(7);
        setIncreaseMana(55);
        setIncreaseMoveSpeed(0.2);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
    }
}
