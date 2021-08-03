package com.dpnw.rtrpg.weapons.ranged.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularWand extends Ranged {

    public AngularWand(Material type) {
        setWeaponName(WeaponName.ANGULAR_WAND);
        setDisplayName("반듯한 지팡이");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(88);
        setAttackSpeed(1.6);
        setCriticalChance(30);
        setCriticalDamage(2);
        setHealth(50);
        setMaxMana(108);
        setManaRegen(1.9);
        setMovementSpeed(0.1);
        setRange(15);
        setType(type);
    }
}
