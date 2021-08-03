package com.dpnw.rtrpg.weapons.sword.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularOneHandSword extends Sword {

    public AngularOneHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_ONE_HAND_SWORD);
        setDisplayName("반듯한 한손검");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(77);
        setAttackSpeed(0.9);
        setCriticalChance(30);
        setCriticalDamage(1.5);
        setMaxMana(70);
        setRange(2);
        setHealthRegen(0.7);
        setAngle(90);
        setMovementSpeed(-0.2);
    }


}
