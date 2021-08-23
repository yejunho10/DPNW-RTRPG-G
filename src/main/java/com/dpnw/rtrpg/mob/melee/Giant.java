package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class Giant extends CraftRMob {

    public Giant() {

    }

    public Giant(ActiveMob mob) {
        super(mob);
        setHealth(1000);
        setDamage(400);
        setArmor(150);
        setAttackSpeed(1.0);
        setSpeed(0.9);
        setRank(MobRank.RARE);
        setStartLevel(35);
        setMaxLevel(35);
        setUUID(mob.getUniqueId());
        setMobName(MobName.GIANT);
        setExp(800);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}