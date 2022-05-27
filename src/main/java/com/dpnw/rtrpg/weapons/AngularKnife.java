package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class AngularKnife extends DualSword {
    public AngularKnife() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(70);
        setDefaultWeaponAttackSpeed(1.4);
        setDefaultWeaponCritChance(45);
        setDefaultWeaponCritDamage(2.25);
        setIncreaseHealth(70);
        setDodgeChance(4);
        setIncreaseMana(65);
        setIncreaseMoveSpeed(0.1);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
    }
}
