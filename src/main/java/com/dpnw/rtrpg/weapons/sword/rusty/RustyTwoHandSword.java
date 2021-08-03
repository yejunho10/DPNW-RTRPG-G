package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyTwoHandSword extends Sword {

    public RustyTwoHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_TWO_HAND_SWORD);
        setDisplayName("녹슨 양손검");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(72);
        setAttackSpeed(0.85);
        setCriticalChance(15);
        setCriticalDamage(2);
        setHealth(75);
        setHealthRegen(0.4);
        setMaxMana(40);
        setManaRegen(0.3);
        setArmor(49);
        setRange(3);
        setAngle(165);
    }


}
