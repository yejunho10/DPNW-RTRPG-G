package com.dpnw.rtrpg.weapons.ranged.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularDagger extends Ranged {

    public AngularDagger(Material type) {
        setWeaponName(WeaponName.ANGULAR_DAGGER);
        setDisplayName("반듯한 표창");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(35);
        setAttackSpeed(3.0);
        setCriticalChance(25);
        setCriticalDamage(2.0);
        setHealth(40);
        setMaxMana(60);
        setManaRegen(0.9);
        setMovementSpeed(0.3);
        setVectorSpeed(1.5);
        setProjectileDeleteTime(0.5);
        setDodgeChance(6);
        setType(type);
    }
}
