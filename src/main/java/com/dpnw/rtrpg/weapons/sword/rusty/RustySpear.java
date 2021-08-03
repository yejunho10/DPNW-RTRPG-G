package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustySpear extends Sword {

    public RustySpear(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_SPEAR);
        setDisplayName("녹슨 창");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(65);
        setAttackSpeed(0.8);
        setCriticalChance(30);
        setCriticalDamage(1.5);
        setHealth(58);
        setManaRegen(0.2);
        setRange(4);
        setReach(1.5);
        setKnockBack(0.5);
        setAngle(10);
    }


}
