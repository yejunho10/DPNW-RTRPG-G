package com.dpnw.rtrpg.weapons.sword.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularKnife extends Sword {

    public AngularKnife(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_KNIFE);
        setDisplayName("반듯한 단도");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(70);
        setAttackSpeed(1.4);
        setCriticalChance(45);
        setCriticalDamage(2.25);
        setHealth(70);
        setMaxMana(65);
        setDodgeChance(4);
        setMovementSpeed(0.1);
        setRange(2);
        setAngle(90);
    }


}
