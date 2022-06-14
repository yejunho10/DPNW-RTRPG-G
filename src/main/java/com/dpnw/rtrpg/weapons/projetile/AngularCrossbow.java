package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class AngularCrossbow extends Crossbow {
    /**
     * 반듯한 석궁
     */
    public AngularCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(106);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(60);
        setIncreaseMana(70);
        setIncreaseManaRegen(0.9);
        setIncreaseMoveSpeed(-0.1);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_CROSSBOW);
    }
}
