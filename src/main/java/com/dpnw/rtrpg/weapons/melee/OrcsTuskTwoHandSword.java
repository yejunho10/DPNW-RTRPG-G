package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.TwoHandSword;

@SuppressWarnings("all")
public class OrcsTuskTwoHandSword extends TwoHandSword {
    public OrcsTuskTwoHandSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(110);
        setDefaultWeaponAttackSpeed(1);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(100);
        setIncreaseHealthRegen(0.6);
        setIncreaseMana(77);
        setIncreaseManaRegen(0.45);
        setIncreaseArmor(70);
        setIncreaseMoveSpeed(0.1);
        setFlavorText("오크의 엄니를 가공해 만든 무기다. 매우 견고하고 가볍다.");
        setWeaponName(WeaponName.ORCS_TUSK_TWO_HAND_SWORD);
    }
}
