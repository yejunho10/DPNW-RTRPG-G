package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class RustyMace extends Mace {
    /**
     * 녹슨 메이스
     */
    public RustyMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(75);
        setDefaultWeaponAttackSpeed(0.75);
        setIncreaseHealth(85);
        setIncreaseHealthRegen(1);
        setStunChance(20);
        setStunDuration(0.7);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_MACE);
    }
}
