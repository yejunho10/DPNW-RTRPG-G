package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class AngularSpear extends DualSword { //todo - setReach(2); setKnockBack(1);
    public AngularSpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(87);
        setDefaultWeaponAttackSpeed(0.7);
        setDefaultWeaponCritChance(40);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(75);
        setIncreaseManaRegen(0.1);
        setIncreaseMoveSpeed(-0.3);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setCurrentWeaponRange(4);
    }
}