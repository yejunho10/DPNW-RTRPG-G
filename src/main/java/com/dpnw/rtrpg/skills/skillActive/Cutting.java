package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/*
Unlock : 메인퀘스트 1 완료

Use : 정면을 한 번 베어 15 +(레벨당 2)의 피해를 준다.

Damage : 15 +(2 for a lv)
Range : 4
Require mana : 25
Cooldown : 5Secs
Rank : Common
Visible : true
 */
@SuppressWarnings("all")
public class Cutting extends RActive {

    public Cutting() {
        setDamage(15);
        setRange(4);
        setCooldown(5);
        setRank(Rank.COMMON);
        setRequireMana(25);
        setDuration(7);
        setVisible(true);
        setSkillName(SkillName.CUTTING);
    }

    public Cutting(Player p) {
        setDamage(15);
        setRange(4);
        setCooldown(5);
        setRank(Rank.COMMON);
        setRequireMana(25);
        setDuration(7);
        setVisible(true);
        setSkillName(SkillName.CUTTING);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 1 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        try {
            Player p = rp.getPlayer();
            if (isCooldown()) return;
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 180, p.getEyeLocation().getDirection())) {
                if (e instanceof ArmorStand) continue;
                LivingEntity le = (LivingEntity) e;
                System.out.println(e.getType());
                //damage
                CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                rmob.damage(getDamage() + 2 * rp.getLevel(), rp.getPlayer());
            }
            for (Vector v : Cone.getPositionsInCone(p.getLocation().toVector(), getRange(), 180,
                    p.getLocation().getDirection())) {
                ParticleUtil.createParticle(p, Particle.CRIT, v.toLocation(p.getWorld()), 0, 1, 0, 1, 0);
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 0.5f, 1.8f);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
            cooldown(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel() {

    }
}
