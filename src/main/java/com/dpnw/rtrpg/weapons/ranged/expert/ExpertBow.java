package com.dpnw.rtrpg.weapons.ranged.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;

@SuppressWarnings("unused")
public class ExpertBow extends Ranged {

    public ExpertBow() {
        setWeaponName(WeaponName.EXPERT_BOW);
        setDisplayName("숙련자의 활");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(47);
        setAttackSpeed(1.5);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(15);
        setManaRegen(0.4);
        setMovementSpeed(0.2);
        setDodgeChance(8);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.25);
    }


}
