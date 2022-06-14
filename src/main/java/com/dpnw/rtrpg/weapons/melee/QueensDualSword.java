package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class QueensDualSword extends DualSword {
    /**
     * 여왕의 쌍검
     */
    public QueensDualSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(37);
        setDefaultWeaponAttackSpeed(2.0);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(45);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(7);
        setFlavorText("날 부분에 약간의 분홍빛이 감도는 우아한 무기다.");
        setWeaponName(WeaponName.QUEENS_DUAL_SWORD);
    }
}
