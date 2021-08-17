package com.dpnw.rtrpg.weapons.ranged.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeDagger extends Ranged {

    public SlimeDagger(Material type) {
        setWeaponName(WeaponName.SLIME_DAGGER);
        setDisplayName("점액질 표창");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 표창이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(27);
        setAttackSpeed(3);
        setCriticalChance(20);
        setCriticalDamage(1.15);
        setHealth(15);
        setMaxMana(35);
        setManaRegen(0.5);
        setMovementSpeed(0.3);
        setVectorSpeed(1.5);
        setProjectileDeleteTime(0.5);
        setDodgeChance(15);
        setType(type);
    }


}
