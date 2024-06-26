package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Spear;

@SuppressWarnings("all")
public class RustySpear extends Spear {
    /**
     * 녹슨 창
     */
    public RustySpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(65);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(58);
        setIncreaseManaRegen(0.2);
        setReach(1.5);
        setKnockBack(0.5);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_SPEAR);
    }
}