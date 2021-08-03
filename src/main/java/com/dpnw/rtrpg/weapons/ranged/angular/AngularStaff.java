package com.dpnw.rtrpg.weapons.ranged.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularStaff extends Ranged {

    public AngularStaff(Material type) {
        setWeaponName(WeaponName.ANGULAR_STAFF);
        setDisplayName("반듯한 스태프");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(100);
        setAttackSpeed(0.8);
        setCriticalChance(5);
        setCriticalDamage(3);
        setHealth(60);
        setMaxMana(140);
        setManaRegen(1.1);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
        setMovementSpeed(-0.2);
        setType(type);
    }
}
