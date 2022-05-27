package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Dagger;

@SuppressWarnings("all")
public class SlimeDagger extends Dagger {
    public SlimeDagger() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(27);
        setDefaultWeaponAttackSpeed(3);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealth(15);
        setIncreaseMana(35);
        setIncreaseManaRegen(0.5);
        setDodgeChance(15);
        setIncreaseMoveSpeed(0.3);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 표창이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
