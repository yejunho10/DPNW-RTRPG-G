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
import com.dpnw.rtrpg.utils.RMobUtil;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 공중에 10초 이상 떠 있었다.

Use : 시전시 전방으로 돌진한다. 도중에 적과 부딪히면, 대상을 살짝 밀어내고 155 +(lv * 2)의 피해를 줍니다. 그후 뒤로 크게 도약하고 잠시동안 공중에 고정된 상태가 되며 바라보고 있는 방향으로 각각 75 +(lv * 5)의 피해를 주는 투사체를 빠르게 세 발 발사합니다.

Damage : 155 +(lv * 2)
Second Damage : 75 +(lv * 5)
Range : 7
Cooldown : 10
Duration : 1
Ticks : 3
Require mana : 75
Rank : Uncommon
Visible : false
 */
@SuppressWarnings("all")
public class FairWind extends RActive {
    private BukkitTask task;

    public FairWind() {
        setDamage(155);
        setSecondDamage(75);
        setCooldown(10);
        setRank(Rank.UNCOMMON);
        setRequireMana(75);
        setRange(7);
        setDuration(1);
        setVisible(false);
        setSkillName(SkillName.FAIRWIND);
    }

    public FairWind(Player p) {
        setDamage(155);
        setSecondDamage(75);
        setCooldown(10);
        setRank(Rank.UNCOMMON);
        setRequireMana(75);
        setRange(7);
        setDuration(1);
        setVisible(false);
        setSkillName(SkillName.FAIRWIND);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp == null) return;
            if (cp.getT_FlyTime() >= 10) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "공중에 10초 이상 떠 있었다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        rp.getPlayer().setVelocity(rp.getPlayer().getLocation().getDirection().multiply(3).add(new Vector(0, -3, 0)));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            LivingEntity le = RMobUtil.getNearestLivingEntity(rp.getPlayer().getLocation(), 2);
            if (le == null) return;
            CraftRMob rm = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
            if (rm == null) return;
            le.setVelocity(rp.getPlayer().getLocation().getDirection().multiply(1));
            rm.damage(getDamage() + rp.getLevel() * 2, rp.getPlayer());
            rp.getPlayer().setVelocity(rp.getPlayer().getLocation().getDirection().multiply(-4).add(new Vector(0, 1, 0)));
            float speed = rp.getPlayer().getWalkSpeed();
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                rp.getPlayer().setVelocity(new Vector(0, 0, 0));
                rp.getPlayer().setGravity(false);
                rp.getPlayer().setWalkSpeed(0);
                Arrow ar = rp.getPlayer().launchProjectile(Arrow.class, rp.getPlayer().getLocation().getDirection().multiply(2.5));
                init(rp, ar);
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                    Arrow ar1 = rp.getPlayer().launchProjectile(Arrow.class, rp.getPlayer().getLocation().getDirection().multiply(2.5));
                    init(rp, ar1);
                }, 5L);
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                    Arrow ar2 = rp.getPlayer().launchProjectile(Arrow.class, rp.getPlayer().getLocation().getDirection().multiply(2.5));
                    init(rp, ar2);
                }, 10L);
            }, 10L);
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                rp.getPlayer().setWalkSpeed(speed);
                rp.getPlayer().setGravity(true);
            }, 25L);
        }, 10L);
        cooldown(this);
    }

    public void init(RPlayer rp, Arrow ar) {
        ar.setBounce(false);
        ar.setShooter(rp.getPlayer());
        ar.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        ar.setMetadata("skill", new FixedMetadataValue(RTRPG.getInstance(), getSkillName().getRaw()));
        ar.setMetadata("fixed-damage", new FixedMetadataValue(RTRPG.getInstance(), getSecondDamage() + 5 * rp.getLevel()));
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
