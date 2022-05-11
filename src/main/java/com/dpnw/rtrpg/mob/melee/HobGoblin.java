package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class HobGoblin extends CraftRMob {

    public HobGoblin() {

    }

    public HobGoblin(ActiveMob mob) {
        super(mob);
        setHealth(175);
        setHealthPerLevel(10);
        setArmor(25);
        setArmorPerLevel(4);
        setDamage(90);
        setDamagePerLevel(1);
        setAttackSpeed(0.7);
        setSpeed(0.7);
        setRank(MobRank.NORMAL);
        setStartLevel(13);
        setMaxLevel(17);
        setUUID(mob.getUniqueId());
        setMobName(MobName.HOB_GOBLIN);
        setExp(130);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}