package com.dpnw.rtrpg.weapons.ranged.etc;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

public class DerFreischutz extends Ranged {

    public DerFreischutz(Material type) {
        setWeaponName(WeaponName.DER_FREISCHUTZ);
        setDisplayName("마탄의 사수");
        setFlavorText("자미엘로부터 수여받은 마법의 무기다. 탄환을 한 발 장전할 때마다 사악한 기운이 당신의 손목을 휘어감는다.");
        setRank(Rank.EXTRA);
        setDamage(700);
        setAttackSpeed(0.7);
        setCriticalChance(45);
        setCriticalDamage(3);
        setHealth(510);
        setMaxMana(570);
        setManaRegen(2.3);
        setProjectileDeleteTime(0.7);
        setVectorSpeed(3);
        setType(type);
    }

}
