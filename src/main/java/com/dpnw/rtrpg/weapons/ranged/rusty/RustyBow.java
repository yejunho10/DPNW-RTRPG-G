package com.dpnw.rtrpg.weapons.ranged.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyBow extends Ranged {

    public RustyBow(Material type) {
        setWeaponName(WeaponName.RUSTY_BOW);
        setDisplayName("녹슨 활");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(70);
        setAttackSpeed(1.5);
        setCriticalChance(15);
        setCriticalDamage(1.5);
        setHealth(46);
        setManaRegen(0.7);
        setMovementSpeed(0.3);
        setDodgeChance(8);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.25);
        setType(type);
    }
}
