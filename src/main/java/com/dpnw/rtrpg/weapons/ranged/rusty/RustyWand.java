package com.dpnw.rtrpg.weapons.ranged.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyWand extends Ranged {

    public RustyWand(Material type) {
        setWeaponName(WeaponName.RUSTY_WAND);
        setDisplayName("녹슨 지팡이");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(55);
        setAttackSpeed(1.8);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(35);
        setMaxMana(95);
        setManaRegen(1.5);
        setMovementSpeed(0.3);
        setRange(15);
        setType(type);
    }
}
