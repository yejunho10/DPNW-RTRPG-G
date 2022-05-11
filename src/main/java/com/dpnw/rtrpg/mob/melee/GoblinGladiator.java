package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class GoblinGladiator extends CraftRMob {

    public GoblinGladiator() {

    }

    public GoblinGladiator(ActiveMob mob) {
        super(mob);
        setHealth(300);
        setHealthPerLevel(5);
        setDamage(100);
        setDamagePerLevel(1);
        setArmor(35);
        setArmorPerLevel(5);
        setAttackSpeed(0.8);
        setSpeed(0.8);
        setRank(MobRank.NORMAL);
        setStartLevel(15);
        setMaxLevel(20);
        setUUID(mob.getUniqueId());
        setMobName(MobName.GOBLIN_GLADIATOR);
        setExp(160);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}