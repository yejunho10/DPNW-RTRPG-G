package com.dpnw.rtrpg.weapons.ranged.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertWand extends Ranged {

    public ExpertWand(Material type) {
        setWeaponName(WeaponName.EXPERT_WAND);
        setDisplayName("숙련자의 지팡이");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(35);
        setAttackSpeed(1.7);
        setCriticalChance(30);
        setCriticalDamage(1.25);
        setHealth(10);
        setMaxMana(70);
        setManaRegen(1);
        setMovementSpeed(0.3);
        setRange(15);
        setType(type);
    }


}
