package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class SlimeWand extends Wand {
    public SlimeWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(47);
        setDefaultWeaponAttackSpeed(1.55);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(30);
        setIncreaseMana(90);
        setIncreaseManaRegen(1.2);
        setIncreaseMoveSpeed(0.2);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 지팡이이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
