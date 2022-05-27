package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertAxe extends DualSword {
    public ExpertAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(58);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(68);
        setIncreaseHealthRegen(0.3);
        setLifeSteal(5);
    }
}
