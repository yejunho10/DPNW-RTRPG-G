package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Spear;

@SuppressWarnings("all")
public class SlimeSpear extends Spear {
    public SlimeSpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(54);
        setDefaultWeaponAttackSpeed(0.7);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(56);
        setIncreaseManaRegen(0.3);
        setReach(1);
        setKnockBack(0.5);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 창이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.SLIME_SPEAR);
    }
}