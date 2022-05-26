
package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OrcsTuskSpear extends DualSword { //todo - setReach(2); setKnockBack(1.5);
    public OrcsTuskSpear() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(135);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(115);
        setIncreaseManaRegen(0.4);
        setCurrentWeaponRange(4);
    }
}