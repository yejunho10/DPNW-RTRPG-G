package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeWand extends DualSword {
    public ApprienticeWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(28);
        setDefaultWeaponAttackSpeed(1.7);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(45);
        setIncreaseManaRegen(0.7);
        setIncreaseMoveSpeed(0.2);
    }
}
