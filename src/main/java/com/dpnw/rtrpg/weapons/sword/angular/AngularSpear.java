package com.dpnw.rtrpg.weapons.sword.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularSpear extends Sword {

    public AngularSpear(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_SPEAR);
        setDisplayName("반듯한 창");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(87);
        setAttackSpeed(0.7);
        setCriticalChance(40);
        setCriticalDamage(1.75);
        setHealth(75);
        setManaRegen(0.1);
        setRange(4);
        setReach(2);
        setKnockBack(1);
        setAngle(10);
        setMovementSpeed(-0.3);
    }


}
