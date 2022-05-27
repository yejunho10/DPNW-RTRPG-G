package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeStaff extends DualSword {
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
    }
}
