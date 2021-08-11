package com.dpnw.rtrpg.weapons.blunt.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class OgreClub extends Blunt {

    public OgreClub(Material type) {
        setType(type);
        setWeaponName(WeaponName.OGRE_CLUB); //메이스 종류
        setDisplayName("오우거 몽둥이");
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
        setRank(Rank.RARE);
        setDamage(143);
        setAttackSpeed(0.9);
        setHealth(200);
        setHealthRegen(1.9);
        setStunChance(25);
        setStunDuration(0.5);
        setRange(2);
        setAngle(120);
    }


}
