package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class SpinAttack extends RActive {
    private BukkitTask task;

    public SpinAttack() {
        setDamage(45);
        setCooldown(8);
        setRank(Rank.COMMON);
        setRequireMana(30);
        setRange(5);
        setHealing(15);
        setVisible(true);
        setSkillName(SkillName.SPIN_ATTACK);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 8 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        ParticleUtil.around(p, getRange(), getRange(), Particle.FLAME, 5, 0.1);
        for(Entity e : p.getNearbyEntities(getRange(), getRange(), getRange())) {
            if(e instanceof Player) continue;
            if(e instanceof ArmorStand) continue;
            CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(e.getUniqueId());
            if(rmob == null) continue;
            rmob.damage(getDamage(), rp.getPlayer());
        }
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 0.5f, 1.4f);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
