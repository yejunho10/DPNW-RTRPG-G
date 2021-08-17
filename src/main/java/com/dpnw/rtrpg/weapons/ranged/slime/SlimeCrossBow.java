package com.dpnw.rtrpg.weapons.ranged.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeCrossBow extends Ranged {

    public SlimeCrossBow(Material type) {
        setWeaponName(WeaponName.SLIME_CROSSBOW);
        setDisplayName("점액질 석궁");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 스태프다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(70);
        setAttackSpeed(1.25);
        setCriticalChance(20);
        setCriticalDamage(1.35);
        setHealth(36);
        setMaxMana(49);
        setManaRegen(0.5);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.5);
        setType(type);
    }


}
