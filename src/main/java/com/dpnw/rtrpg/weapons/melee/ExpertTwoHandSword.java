package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertTwoHandSword extends DualSword {
    public ExpertTwoHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(50);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(55);
        setIncreaseHealthRegen(0.5);
        setIncreaseMana(25);
        setIncreaseManaRegen(0.2);
        setIncreaseArmor(25);
    }
}
