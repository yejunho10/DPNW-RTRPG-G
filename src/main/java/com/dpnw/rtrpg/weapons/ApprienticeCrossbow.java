package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeCrossbow extends DualSword {
    public ApprienticeCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(40);
        setDefaultWeaponAttackSpeed(1.3);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(10);
        setIncreaseMana(25);
        setIncreaseManaRegen(0.3);
    }
}
