package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyDagger extends DualSword {
    public RustyDagger() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(33);
        setDefaultWeaponAttackSpeed(3.2);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(25);
        setIncreaseMana(40);
        setIncreaseManaRegen(0.75);
        setDodgeChance(10);
        setIncreaseMoveSpeed(0.5);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
