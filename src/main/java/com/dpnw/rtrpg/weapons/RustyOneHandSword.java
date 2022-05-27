package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyOneHandSword extends DualSword {
    public RustyOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(60);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealthRegen(0.5);
        setIncreaseMana(50);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
