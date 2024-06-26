package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class RustyStaff extends Staff {
    /**
     * 녹슨 스태프
     */
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
        setWeaponName(WeaponName.RUSTY_STAFF);
    }
}
