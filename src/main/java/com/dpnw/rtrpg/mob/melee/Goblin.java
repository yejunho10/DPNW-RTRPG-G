package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class Goblin extends CraftRMob {

    public Goblin(ActiveMob mob) {
        super(mob);
        setHealth(250);
        setHealthPerLevel(7);
        setArmor(25);
        setArmorPerLevel(3);
        setDamage(85);
        setDamagePerLevel(12);
        setAttackSpeed(0.6);
        setSpeed(0.7);
        setRank(MobRank.NORMAL);
        setStartLevel(11);
        setMaxLevel(15);
        setUUID(mob.getUniqueId());
        setMobName(MobName.GOBLIN);
        setExp(110);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}
