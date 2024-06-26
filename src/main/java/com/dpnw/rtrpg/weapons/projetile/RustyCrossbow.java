package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class RustyCrossbow extends Crossbow {
    /**
     * 녹슨 석궁
     */
    public RustyCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(82);
        setDefaultWeaponAttackSpeed(1.3);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(45);
        setIncreaseMana(55);
        setIncreaseManaRegen(0.7);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_CROSSBOW);
    }
}
