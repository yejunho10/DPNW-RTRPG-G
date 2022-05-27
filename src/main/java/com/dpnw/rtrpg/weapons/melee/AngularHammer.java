package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Hammer;

@SuppressWarnings("all")
public class AngularHammer extends Hammer {
    public AngularHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(124);
        setDefaultWeaponAttackSpeed(0.5);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(210);
        setIncreaseHealthRegen(1.7);
        setKnockBack(1);
        setIncreaseMoveSpeed(-0.3);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_HAMMER);
    }
}
