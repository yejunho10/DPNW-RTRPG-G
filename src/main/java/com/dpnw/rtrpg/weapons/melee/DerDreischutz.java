package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class DerDreischutz extends Crossbow {
    public DerDreischutz() {
        setRank(Rank.EXTRA);
        setDefaultWeaponDamage(700);
        setDefaultWeaponAttackSpeed(0.7);
        setDefaultWeaponCritChance(45);
        setDefaultWeaponCritDamage(3);
        setIncreaseHealth(510);
        setIncreaseMana(570);
        setIncreaseManaRegen(2.3);
        setFlavorText("자미엘로부터 수여받은 마법의 무기다. 탄환을 한 발 장전할 때마다 사악한 기운이 당신의 손목을 휘어감는다.");
        setProjectileDeletionTime((long) 0.7);
        setProjectileSpeed(3);
    }
}
