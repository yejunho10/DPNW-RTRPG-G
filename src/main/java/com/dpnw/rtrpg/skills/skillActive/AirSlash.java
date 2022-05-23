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
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 5000블럭 이상을 이동했다.

Use : 시전시 전방을 베어가르며 날아가는 칼바람을 발사합니다. 칼바람은 적을 관통하며, 닿을시 120 +(레벨당 2)의 피해를 입힙니다.

Damage : 120 +(2 for a lv)
Cooldown : 12Secs
Require mana : 40
Range : 20
Rank : Common
Visable : false
 */
@SuppressWarnings("all")
public class AirSlash extends RActive {

    public AirSlash() {
        setDamage(120);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(40);
        setRange(20);
        setVisible(false);
        setSkillName(SkillName.AIR_SLASH);
    }

    public AirSlash(Player p) {
        setDamage(120);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(40);
        setRange(20);
        setVisible(false);
        setSkillName(SkillName.AIR_SLASH);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;

    }

    @Override
    public String skillUnlockCondition() {
        return "5000블럭 이상을 이동했다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        try {
            Player p = rp.getPlayer();
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 90, p.getEyeLocation().getDirection())) {
                if (e instanceof ArmorStand) continue;
                LivingEntity le = (LivingEntity) e;
                System.out.println(e.getType());
                //damage
                CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                if (rmob != null) {
                    rmob.damage(getDamage() + 2 * rp.getLevel(), rp.getPlayer());
                }
            }
            long l = 0;
            for (Vector v : Cone.getPositionsInCone(p.getLocation().toVector(), getRange(), 90,
                    p.getLocation().getDirection())) {
                ParticleUtil.createParticle(p, Particle.CLOUD, v.toLocation(p.getWorld()), 0, 1, 0, 2, 0);
            }
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
