package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertSpear extends DualSword { //todo - setReach(0.5); setKnockBack(0.1);
    public ExpertSpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(47);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(45);
        setIncreaseManaRegen(0.4);
        setCurrentWeaponRange(4);
    }
}