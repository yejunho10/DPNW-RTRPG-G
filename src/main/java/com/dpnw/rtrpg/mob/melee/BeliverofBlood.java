package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class BeliverofBlood extends CraftRMob {

    public BeliverofBlood() {

    }

    public BeliverofBlood(ActiveMob mob) {
        super(mob);
        setHealth(900);
        setHealthPerLevel(50);
        setDamage(310);
        setDamagePerLevel(30);
        setArmor(80);
        setArmorPerLevel(15);
        setAttackSpeed(1.0);
        setSpeed(1.0);
        setRank(MobRank.NORMAL);
        setStartLevel(35);
        setMaxLevel(36);
        setUUID(mob.getUniqueId());
        setMobName(MobName.BELIVER_OF_BLOOD);
        setExp(450);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}