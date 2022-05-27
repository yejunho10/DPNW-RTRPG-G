package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprenticeAxe extends DualSword {
    public ApprenticeAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(43);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(50);
        setIncreaseHealthRegen(0.2);
        setLifeSteal(3);
    }
}
