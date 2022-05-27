package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Dagger;

@SuppressWarnings("all")
public class AngularDagger extends Dagger {
    public AngularDagger() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(3);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(40);
        setIncreaseMana(60);
        setIncreaseManaRegen(0.9);
        setDodgeChance(6);
        setIncreaseMoveSpeed(0.3);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_DAGGER);
    }
}
