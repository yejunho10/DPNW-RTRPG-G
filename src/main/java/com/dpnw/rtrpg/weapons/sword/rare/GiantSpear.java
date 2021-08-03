package com.dpnw.rtrpg.weapons.sword.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class GiantSpear extends Sword {

    public GiantSpear(Material type) {
        setType(type);
        setWeaponName(WeaponName.GIANT_SPEAR);
        setDisplayName("자이언트 스피어");
        setFlavorText("자이언트의 외피와 핵으로 만든 견고한 무기다. 생각보다 그렇게 무겁지는 않다.");
        setRank(Rank.RARE);
        setDamage(145);
        setAttackSpeed(0.9);
        setCriticalChance(55);
        setCriticalDamage(2);
        setHealth(178);
        setManaRegen(0.8);
        setRange(4);
        setReach(2);
        setKnockBack(2);
        setAngle(10);
        setMovementSpeed(-0.1);
    }


}
