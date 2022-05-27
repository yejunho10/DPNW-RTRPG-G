package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeHammer extends DualSword {
    public ApprienticeHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(56);
        setDefaultWeaponAttackSpeed(0.5);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(65);
        setIncreaseHealthRegen(0.5);
        setIncreaseMoveSpeed(-0.1);
    }
}
