package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class AngularMace extends Mace {
    public AngularMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(90);
        setDefaultWeaponAttackSpeed(0.6);
        setIncreaseHealth(110);
        setIncreaseHealthRegen(1.2);
        setStunChance(30);
        setStunDuration(0.5);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_MACE);
    }
}
