package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Axe;

@SuppressWarnings("all")
public class AngularAxe extends Axe {
    public AngularAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(110);
        setDefaultWeaponAttackSpeed(0.5);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(110);
        setIncreaseHealthRegen(0.5);
        setLifeSteal(10);
        setIncreaseMoveSpeed(-0.2);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_AXE);
    }
}
