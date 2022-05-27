package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class RustyOneHandSword extends OneHandSword {
    public RustyOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(60);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealthRegen(0.5);
        setIncreaseMana(50);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_ONE_HAND_SWORD);
    }
}
