package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertTwoHandSword extends Sword {

    public ExpertTwoHandSword(Material type) {
        setWeaponName(WeaponName.EXPERT_TWO_HAND_SWORD);
        setDisplayName("숙련자의 양손검");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(50);
        setAttackSpeed(0.9);
        setCriticalChance(25);
        setCriticalDamage(1.5);
        setHealth(55);
        setHealthRegen(0.4);
        setMaxMana(25);
        setManaRegen(0.2);
        setArmor(25);
        setRange(3);
        setAngle(165);
        setType(type);
    }


}
