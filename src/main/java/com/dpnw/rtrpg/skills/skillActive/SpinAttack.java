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

/*
Unlock : 메인퀘스트 8 완료

Use : 주변을 베어 45 +(레벨당 2)의 피해를 주고 적중한 적 하나당 15 +(레벨당 2)의 체력을 회복합니다.

Damage : 45 +(2 for a lv)
Range : 5
Healing : 15
Require mana : 30
Cooldown : 8
Rank : Common
Visible : true
 */
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
        for (Entity e : p.getNearbyEntities(getRange(), getRange(), getRange())) {
            if (e instanceof Player) continue;
            if (e instanceof ArmorStand) continue;
            CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(e.getUniqueId());
            if (rmob == null) continue;
            rmob.damage(getDamage() + 2 * rp.getLevel(), rp.getPlayer());
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
