package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class OrcsTuskStaff extends Staff {
    /**
     * 오크엄니 스태프
     */
    public OrcsTuskStaff() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(160);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(3.5);
        setIncreaseHealth(100);
        setIncreaseMana(165);
        setIncreaseManaRegen(1.3);
        setFlavorText("오크의 엄니를 가공해 만든 무기다. 매우 견고하고 가볍다.");
        setWeaponName(WeaponName.ORCS_TUSK_STAFF);
    }
}
