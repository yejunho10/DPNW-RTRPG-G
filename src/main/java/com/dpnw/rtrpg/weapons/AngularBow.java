package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class AngularBow extends DualSword {
    public AngularBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(95);
        setDefaultWeaponAttackSpeed(1.3);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(69);
        setIncreaseManaRegen(0.9);
        setIncreaseMoveSpeed(0.1);
        setDodgeChance(4);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
    }
}
