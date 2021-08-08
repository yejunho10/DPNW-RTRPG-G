package com.dpnw.rtrpg.mob;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class QueenSlime extends CraftRMob {

    public QueenSlime() {

    }

    public QueenSlime(ActiveMob mob) {
        super(mob);
        setHealth(300);
        setDamage(110);
        setArmor(45);
        setAttackSpeed(0.4);
        setSpeed(0.8);
        setRank(MobRank.RARE);
        setStartLevel(15);
        setMaxLevel(15);
        setUUID(mob.getUniqueId());
        setMobName(MobName.QUEEN_SLIME);
        setExp(200);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}