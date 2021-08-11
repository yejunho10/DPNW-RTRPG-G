package com.dpnw.rtrpg.weapons.blunt.angular;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularMace extends Blunt {

    public AngularMace(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_HAMMER);
        setDisplayName("반듯한 망치");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setDamage(124);
        setAttackSpeed(0.5);
        setCriticalChance(10);
        setCriticalDamage(1.5);
        setHealth(210);
        setHealthRegen(1.7);
        setKnockBack(1);
        setRange(3);
        setAngle(180);
    }


}
