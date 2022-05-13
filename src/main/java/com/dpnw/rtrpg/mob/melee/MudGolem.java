package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class MudGolem extends CraftRMob {

    public MudGolem() {

    }

    public MudGolem(ActiveMob mob) {
        super(mob);
        setHealth(600);
        setHealthPerLevel(10);
        setDamage(150);
        setDamagePerLevel(5);
        setArmor(50);
        setArmorPerLevel(10);
        setAttackSpeed(0.8);
        setSpeed(0.9);
        setRank(MobRank.NORMAL);
        setStartLevel(24);
        setMaxLevel(26);
        setUUID(mob.getUniqueId());
        setMobName(MobName.MUD_GOLEM);
        setExp(260);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getHealth());
    }
}