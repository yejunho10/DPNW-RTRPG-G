package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Bow;

@SuppressWarnings("all")
public class AngularBow extends Bow {
    /**
     * 반듯한 활
     */
    public AngularBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(95);
        setDefaultWeaponAttackSpeed(1.3);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(69);
        setIncreaseManaRegen(0.9);
        setIncreaseMoveSpeed(0.1);
        setDodgeChance(4);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_BOW);
    }
}
