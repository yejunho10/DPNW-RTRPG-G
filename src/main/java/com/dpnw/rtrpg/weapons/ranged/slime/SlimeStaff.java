package com.dpnw.rtrpg.weapons.ranged.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeStaff extends Ranged {

    public SlimeStaff(Material type) {
        setWeaponName(WeaponName.SLIME_STAFF);
        setDisplayName("점액질 스태프");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 스태프다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(75);
        setAttackSpeed(0.85);
        setCriticalChance(10);
        setCriticalDamage(1.5);
        setHealth(37);
        setMaxMana(85);
        setManaRegen(0.8);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
        setType(type);
    }


}
