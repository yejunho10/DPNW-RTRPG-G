package com.dpnw.rtrpg.weapons.ranged.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyCrossBow extends Ranged {

    public RustyCrossBow(Material type) {
        setWeaponName(WeaponName.RUSTY_CROSSBOW);
        setDisplayName("녹슨 석궁");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(82);
        setAttackSpeed(1.3);
        setCriticalChance(15);
        setCriticalDamage(1.5);
        setHealth(45);
        setMaxMana(55);
        setManaRegen(0.7);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.5);
        setType(type);
    }
}
