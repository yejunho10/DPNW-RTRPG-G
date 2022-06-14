
package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Spear;

@SuppressWarnings("all")
public class OrcsTuskSpear extends Spear {
    /**
     * 오크엄니 창
     */
    public OrcsTuskSpear() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(135);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(115);
        setIncreaseManaRegen(0.4);
        setReach(2);
        setKnockBack(1.5);
        setWeaponName(WeaponName.ORCS_TUSK_SPEAR);
    }
}