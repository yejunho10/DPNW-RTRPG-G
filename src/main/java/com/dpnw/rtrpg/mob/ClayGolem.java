package com.dpnw.rtrpg.mob;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class ClayGolem extends CraftRMob {

    public ClayGolem() {

    }

    public ClayGolem(ActiveMob mob) {
        super(mob);
        setHealth(550);
        setHealthPerLevel(10);
        setDamage(120);
        setDamagePerLevel(5);
        setArmor(45);
        setArmorPerLevel(5);
        setAttackSpeed(0.75);
        setSpeed(0.9);
        setRank(MobRank.NORMAL);
        setStartLevel(21);
        setMaxLevel(23);
        setUUID(mob.getUniqueId());
        setMobName(MobName.CLAY_GOLEM);
        setExp(220);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}