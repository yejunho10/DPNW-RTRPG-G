package com.dpnw.rtrpg.weapons.ranged.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularBow extends Ranged {

    public AngularBow(Material type) {
        setWeaponName(WeaponName.ANGULAR_BOW);
        setDisplayName("반듯한 활");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(95);
        setAttackSpeed(1.3);
        setCriticalChance(20);
        setCriticalDamage(2.0);
        setHealth(69);
        setManaRegen(0.9);
        setMovementSpeed(0.1);
        setDodgeChance(4);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.25);
        setType(type);
    }
}
