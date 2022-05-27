package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeOneHandSword extends DualSword {
    public ApprienticeOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(32);
        setDefaultWeaponAttackSpeed(1.2);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealthRegen(0.3);
        setIncreaseMana(20);
    }
}
