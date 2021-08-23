package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class RockGolem extends CraftRMob {

    public RockGolem() {

    }

    public RockGolem(ActiveMob mob) {
        super(mob);
        setHealth(650);
        setHealthPerLevel(20);
        setDamage(200);
        setDamagePerLevel(5);
        setArmor(65);
        setArmorPerLevel(10);
        setAttackSpeed(0.9);
        setSpeed(0.9);
        setRank(MobRank.NORMAL);
        setStartLevel(27);
        setMaxLevel(29);
        setUUID(mob.getUniqueId());
        setMobName(MobName.ROCK_GOLEM);
        setExp(300);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}