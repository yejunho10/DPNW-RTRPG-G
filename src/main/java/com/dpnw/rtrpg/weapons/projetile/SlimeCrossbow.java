package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class SlimeCrossbow extends Crossbow {
    /**
     * 점액질 석궁
     */
    public SlimeCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(70);
        setDefaultWeaponAttackSpeed(1.25);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.35);
        setIncreaseHealth(36);
        setIncreaseMana(49);
        setIncreaseManaRegen(0.5);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 석궁이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.SLIME_CROSSBOW);
    }
}
