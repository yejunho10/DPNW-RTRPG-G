package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class OrcsTuskWand extends Wand {
    public OrcsTuskWand() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(120);
        setDefaultWeaponAttackSpeed(1.65);
        setDefaultWeaponCritChance(40);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(85);
        setIncreaseMana(160);
        setIncreaseManaRegen(2);
        setIncreaseMoveSpeed(0.4);
        setFlavorText("오크의 엄니를 가공해 만든 무기다. 매우 견고하고 가볍다.");
        setWeaponName(WeaponName.ORCS_TUSK_WAND);
    }
}
