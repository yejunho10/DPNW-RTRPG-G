package com.dpnw.rtrpg.weapons.sword.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularAxe extends Sword {

    public AngularAxe(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_AXE);
        setDisplayName("반듯한 도끼");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(110);
        setAttackSpeed(0.5);
        setCriticalChance(30);
        setCriticalDamage(2);
        setHealth(110);
        setHealthRegen(0.5);
        setLifeSteal(10);
        setMovementSpeed(-0.2);
        setRange(3);
        setAngle(215);
    }


}
