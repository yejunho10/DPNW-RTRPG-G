package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertDualSword extends Sword {

    public ExpertDualSword(Material type) {
        setWeaponName(WeaponName.EXPERT_DUAL_SWORD);
        setDisplayName("숙련자의 쌍검");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(25);
        setAttackSpeed(2);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(25);
        setMovementSpeed(0.2);
        setDodgeChance(3);
        setRange(3);
        setAngle(160);
        setType(type);
    }


}
