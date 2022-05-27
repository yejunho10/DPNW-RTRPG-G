package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class OgreMace extends Mace {
    public OgreMace() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(143);
        setDefaultWeaponAttackSpeed(0.9);
        setIncreaseHealth(200);
        setIncreaseHealthRegen(1.9);
        setStunChance(25);
        setStunDuration(0.5);
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
    }
}
