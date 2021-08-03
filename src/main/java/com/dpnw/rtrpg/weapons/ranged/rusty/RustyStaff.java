package com.dpnw.rtrpg.weapons.ranged.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyStaff extends Ranged {

    public RustyStaff(Material type) {
        setWeaponName(WeaponName.RUSTY_STAFF);
        setDisplayName("녹슨 스태프");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(85);
        setAttackSpeed(0.95);
        setCriticalChance(5);
        setCriticalDamage(2);
        setHealth(46);
        setMaxMana(100);
        setManaRegen(0.9);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
        setType(type);
    }
}
