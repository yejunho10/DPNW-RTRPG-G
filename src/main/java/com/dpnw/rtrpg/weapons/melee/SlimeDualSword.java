package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeDualSword extends DualSword {
    public SlimeDualSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(27);
        setDefaultWeaponAttackSpeed(1.9);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(31);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(5);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 쌍검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
