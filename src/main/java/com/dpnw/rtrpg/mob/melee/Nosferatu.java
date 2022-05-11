package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class Nosferatu extends CraftRMob {

    public Nosferatu() {

    }

    public Nosferatu(ActiveMob mob) { //lifesteal 관련 아직 필드도 안만듬
        super(mob);
        setHealth(1300);
        setDamage(700);
        setArmor(130);
        setAttackSpeed(0.6);
        setSpeed(1.0);
        setRank(MobRank.RARE);
        setStartLevel(40);
        setMaxLevel(40);
        setUUID(mob.getUniqueId());
        setMobName(MobName.NOSFERATU);
        setExp(1500);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}