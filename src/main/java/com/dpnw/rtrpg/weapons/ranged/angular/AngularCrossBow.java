package com.dpnw.rtrpg.weapons.ranged.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularCrossBow extends Ranged {

    public AngularCrossBow(Material type) {
        setWeaponName(WeaponName.ANGULAR_CROSSBOW);
        setDisplayName("반듯한 석궁");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(106);
        setAttackSpeed(1.1);
        setCriticalChance(20);
        setCriticalDamage(2);
        setHealth(60);
        setMaxMana(70);
        setManaRegen(0.9);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.5);
        setMovementSpeed(-0.1);
        setType(type);
    }
}
