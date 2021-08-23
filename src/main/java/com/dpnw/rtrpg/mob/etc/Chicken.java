package com.dpnw.rtrpg.mob.etc;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class Chicken extends CraftRMob {

    public Chicken() {
        setHealth(50);
        setDamage(1);
        setRank(MobRank.NORMAL);
        setStartLevel(1);
        setMaxLevel(1);
        setMobName(MobName.CHICKEN);
    }

    public Chicken(ActiveMob mob) {
        super(mob);
        setHealth(50);
        setDamage(1);
        setRank(MobRank.NORMAL);
        setStartLevel(1);
        setMaxLevel(1);
        setUUID(mob.getUniqueId());
        setMobName(MobName.CHICKEN);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}