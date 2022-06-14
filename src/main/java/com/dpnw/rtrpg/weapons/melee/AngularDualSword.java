package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class AngularDualSword extends DualSword {
    /**
     * 반듯한 쌍검
     */
    public AngularDualSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(45);
        setDefaultWeaponAttackSpeed(2.5);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(50);
        setDodgeChance(2);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_DUAL_SWORD);
    }
}
