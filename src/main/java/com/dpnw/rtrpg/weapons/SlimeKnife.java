package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeKnife extends DualSword {
    public SlimeKnife() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(45);
        setDefaultWeaponAttackSpeed(1.4);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(45);
        setDodgeChance(10);
        setIncreaseMana(50);
        setIncreaseMoveSpeed(0.2);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 단도다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
