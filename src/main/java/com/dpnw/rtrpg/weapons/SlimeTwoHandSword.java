package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeTwoHandSword extends DualSword {
    public SlimeTwoHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(65);
        setDefaultWeaponAttackSpeed(0.75);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(70);
        setIncreaseHealthRegen(0.5);
        setIncreaseMana(36);
        setIncreaseManaRegen(0.35);
        setIncreaseArmor(37);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 양손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
