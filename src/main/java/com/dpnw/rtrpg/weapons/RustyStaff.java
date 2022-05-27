package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyStaff extends DualSword {
    public RustyStaff() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(85);
        setDefaultWeaponAttackSpeed(0.95);
        setDefaultWeaponCritChance(5);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(46);
        setIncreaseMana(100);
        setIncreaseManaRegen(0.9);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
