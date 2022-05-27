package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertOneHandSword extends DualSword {
    public ExpertOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(44);
        setDefaultWeaponAttackSpeed(1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealthRegen(0.6);
        setIncreaseMana(47);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 한손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
