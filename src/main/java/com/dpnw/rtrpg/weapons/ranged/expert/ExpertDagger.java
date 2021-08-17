package com.dpnw.rtrpg.weapons.ranged.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertDagger extends Ranged {

    public ExpertDagger(Material type) {
        setWeaponName(WeaponName.EXPERT_DAGGER);
        setDisplayName("숙련자의 표창");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(20);
        setAttackSpeed(3.2);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(5);
        setMaxMana(20);
        setManaRegen(0.4);
        setMovementSpeed(0.4);
        setVectorSpeed(1.5);
        setProjectileDeleteTime(0.5);
        setDodgeChance(15);
        setType(type);
    }


}
