package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Bow;

@SuppressWarnings("all")
public class SlimeBow extends Bow {
    public SlimeBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(56);
        setDefaultWeaponAttackSpeed(1.45);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealth(35);
        setIncreaseManaRegen(0.6);
        setIncreaseMoveSpeed(0.1);
        setDodgeChance(9.5);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 활이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
