package com.dpnw.rtrpg.weapons.blunt.angular;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AngularHammer extends Blunt {

    public AngularHammer(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_MACE);
        setDisplayName("반듯한 메이스");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setDamage(90);
        setAttackSpeed(0.6);
        setHealth(110);
        setHealthRegen(1.2);
        setStunChance(30);
        setStunDuration(0.5);
        setRange(2);
        setAngle(120);
        setMovementSpeed(-0.3);
    }


}
