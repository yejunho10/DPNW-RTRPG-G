package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class ExpertWand extends Wand {
    public ExpertWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(1.7);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(10);
        setIncreaseMana(70);
        setIncreaseManaRegen(1);
        setIncreaseMoveSpeed(0.3);
        setWeaponName(WeaponName.EXPERT_WAND);
    }
}
