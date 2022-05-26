package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeSpear extends DualSword { //todo - setReach(1); setKnockBack(0.5);
    public SlimeSpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(54);
        setDefaultWeaponAttackSpeed(0.7);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(56);
        setIncreaseManaRegen(0.3);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 창이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setCurrentWeaponRange(4);
    }
}