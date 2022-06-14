package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyDualSword extends DualSword {
    /**
     * 녹슨 쌍검
     */
    public RustyDualSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(30);
        setDefaultWeaponAttackSpeed(2.1);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(30);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(4);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_DUAL_SWORD);
    }
}
