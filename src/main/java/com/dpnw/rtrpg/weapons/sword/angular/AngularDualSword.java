package com.dpnw.rtrpg.weapons.sword.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularDualSword extends Sword {

    public AngularDualSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_DUAL_SWORD);
        setDisplayName("반듯한 쌍검");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(45);
        setAttackSpeed(2.5);
        setCriticalChance(25);
        setCriticalDamage(1.75);
        setHealth(50);
        setDodgeChance(2);
        setRange(3);
        setAngle(160);
    }


}
