package com.dpnw.rtrpg.weapons.ranged.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class GiantStaff extends Ranged {

    public GiantStaff(Material type) {
        setWeaponName(WeaponName.GIANT_STAFF);
        setDisplayName("자이언트 스태프");
        setFlavorText("자이언트의 외피와 핵으로 만든 견고한 무기다. 생각보다 그렇게 무겁지는 않다.");
        setRank(Rank.RARE);
        setDamage(190);
        setAttackSpeed(0.95);
        setCriticalChance(15);
        setCriticalDamage(3);
        setHealth(110);
        setMaxMana(300);
        setManaRegen(1.7);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
        setType(type);
    }
}
