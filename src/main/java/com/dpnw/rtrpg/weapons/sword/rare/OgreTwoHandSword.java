package com.dpnw.rtrpg.weapons.sword.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class OgreTwoHandSword extends Sword {

    public OgreTwoHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.OGRE_TWO_HAND_SWORD);
        setDisplayName("오우거 대검");
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
        setRank(Rank.RARE);
        setDamage(135);
        setAttackSpeed(1.2);
        setCriticalChance(33);
        setCriticalDamage(2.5);
        setHealth(110);
        setHealthRegen(0.8);
        setMaxMana(90);
        setManaRegen(0.5);
        setArmor(78);
        setRange(3);
        setAngle(165);
    }


}
