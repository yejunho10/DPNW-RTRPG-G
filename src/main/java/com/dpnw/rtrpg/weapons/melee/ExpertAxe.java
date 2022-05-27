package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Axe;

@SuppressWarnings("all")
public class ExpertAxe extends Axe {
    public ExpertAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(58);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(68);
        setIncreaseHealthRegen(0.3);
        setLifeSteal(5);
        setWeaponName(WeaponName.EXPERT_AXE);
    }
}
