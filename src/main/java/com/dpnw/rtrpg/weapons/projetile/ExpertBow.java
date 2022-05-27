package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertBow extends DualSword {
    public ExpertBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(47);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(15);
        setIncreaseManaRegen(0.4);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(8);
    }
}
