package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyDualSword extends Sword {

    public RustyDualSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_DUAL_SWORD);
        setDisplayName("녹슨 쌍검");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(30);
        setAttackSpeed(2.1);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(30);
        setMovementSpeed(0.2);
        setDodgeChance(4);
        setRange(3);
        setAngle(160);
    }


}
