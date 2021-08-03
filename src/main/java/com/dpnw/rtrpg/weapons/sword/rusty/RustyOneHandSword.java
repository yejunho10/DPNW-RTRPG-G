package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyOneHandSword extends Sword {

    public RustyOneHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_ONE_HAND_SWORD);
        setDisplayName("녹슨 한손검");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(60);
        setAttackSpeed(1.1);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setMaxMana(50);
        setRange(2);
        setHealthRegen(0.5);
        setAngle(90);
    }


}
