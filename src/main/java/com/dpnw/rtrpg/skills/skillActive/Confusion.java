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
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 공중에 7초 이상 떠 있었다.
Use : 시전 즉시 주변의 모든 적들에게 95 +(LV * 3)의 피해를 주고 2초간 실명 시킵니다. 그리고 시전자는 7칸 위로 순간이동 합니다.
Damage : 90 +(lv * 3)
Duration : 2
Range : 6
Cooldown : 8
Require mana : 50
Rank : Uncommon
Visible : false
 */
public class Confusion extends RActive {
    private BukkitTask task;

    public Confusion() {
        setDamage(90);
        setDuration(2);
        setRange(6);
        setCooldown(8);
        setRequireMana(50);
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.CONFUSION);
    }

    public Confusion(Player p) {
        setDamage(90);
        setDuration(2);
        setRange(6);
        setCooldown(8);
        setRequireMana(50);
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.CONFUSION);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp == null) return;
            if (cp.getT_FlyTime() >= 7) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 10L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "공중에 7초 이상 떠 있었다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            p.getPlayer().getNearbyEntities(getRange(), getRange(), getRange()).forEach(e -> {
                if (e instanceof LivingEntity le) {
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    if (rmob != null) {
                        rmob.damage(getDamage() + (p.getLevel() * 5), p.getPlayer());
                        le.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 1));
                        ParticleUtil.createParticle(le, Particle.SMOKE_NORMAL, le.getLocation().add(0, 1, 0), 0, 0, 0, 10, 1);
                    }
                }
            });
            ParticleUtil.around(p.getPlayer(), 0, getRange(), Particle.CRIT, 1, 0.1);
        });
        p.getPlayer().teleport(p.getPlayer().getLocation().add(0, 7, 0));
        cooldown(this);
    }


    @Override
    public void cancel() {
        try {
            task.cancel();
            task = null;
        } catch (Exception ignored) {
        }
    }
}