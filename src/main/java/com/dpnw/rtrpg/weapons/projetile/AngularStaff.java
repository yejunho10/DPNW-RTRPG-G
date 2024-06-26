package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class AngularStaff extends Staff {
    /**
     * 반듯한 스태프
     */
    public AngularStaff() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(100);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(5);
        setDefaultWeaponCritDamage(3);
        setIncreaseHealth(60);
        setIncreaseMana(140);
        setIncreaseManaRegen(1.1);
        setIncreaseMoveSpeed(-0.2);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_STAFF);
    }
}
