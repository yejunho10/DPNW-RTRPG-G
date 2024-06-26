package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class SlimeStaff extends Staff {
    /**
     * 점액질 스태프
     */
    public SlimeStaff() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(75);
        setDefaultWeaponAttackSpeed(0.85);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(37);
        setIncreaseMana(85);
        setIncreaseManaRegen(0.8);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 스태프다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.SLIME_STAFF);
    }
}
