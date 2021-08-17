package com.dpnw.rtrpg.weapons.ranged.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeBow extends Ranged {

    public SlimeBow(Material type) {
        setWeaponName(WeaponName.SLIME_BOW);
        setDisplayName("점액질 활");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 활이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(56);
        setAttackSpeed(1.45);
        setCriticalChance(20);
        setCriticalDamage(1.15);
        setHealth(35);
        setManaRegen(0.6);
        setMovementSpeed(0.1);
        setDodgeChance(9.5);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.25);
        setType(type);
    }
}
