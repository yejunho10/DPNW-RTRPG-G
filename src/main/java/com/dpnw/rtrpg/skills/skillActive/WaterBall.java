package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class WaterBall extends RActive {
/*
Unlock : 상점에서 구매

Use : 바라본 방향으로 포물선을 그리며 날아가는 물방울을 날려 맞은 대상에게 145 +(레벨당 2)의 피해를 입히고, 2초간 물감옥에 가둬 공중에 떠올립니다.

Damage : 145 +(2 for a lv)
Duration : 2Secs
Range : 2
Require mana : 68
Cooldown : 8Secs
Rank : Uncommon
Visible : false
*/

    public WaterBall() {
        setDamage(145);
        setRange(2);
        setCooldown(8);
        setRank(Rank.UNCOMMON);
        setRequireMana(68);
        setVisible(false);
        setSkillName(SkillName.WATER_BALL);
        setBuyFromShop(true);
    }

    @Override
    public String skillUnlockCondition() {
        return "상점에서 구매";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        try {
            Player p = rp.getPlayer();
            Arrow ar = p.launchProjectile(Arrow.class);
            ar.setDamage(getDamage());
            ar.setBounce(false);
            ar.setGravity(true);
            ar.setVelocity(p.getLocation().getDirection().multiply(3));
            ar.setShooter(p);
            ar.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
            ar.setMetadata("skill", new FixedMetadataValue(RTRPG.getInstance(), getSkillName().getRaw()));
            RTRPG.getInstance().projectileList.add(ar.getUniqueId());
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                RTRPG.getInstance().projectileList.remove(ar.getUniqueId());
                ar.remove();
            }, 100L);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 0.5f, 1.4f);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
