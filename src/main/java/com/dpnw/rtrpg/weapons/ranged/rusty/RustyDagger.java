package com.dpnw.rtrpg.weapons.ranged.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyDagger extends Ranged {

    public RustyDagger(Material type) {
        setWeaponName(WeaponName.RUSTY_DAGGER);
        setDisplayName("녹슨 표창");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(33);
        setAttackSpeed(3.2);
        setCriticalChance(15);
        setCriticalDamage(1.15);
        setHealth(25);
        setMaxMana(40);
        setManaRegen(0.75);
        setMovementSpeed(0.5);
        setVectorSpeed(1.5);
        setProjectileDeleteTime(0.5);
        setDodgeChance(10);
        setType(type);
    }
}
