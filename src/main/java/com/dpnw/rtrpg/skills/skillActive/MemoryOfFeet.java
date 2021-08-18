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
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class MemoryOfFeet extends RActive {
    private BukkitTask task;
    private Location loc;
    private boolean ready = false;

    public MemoryOfFeet() {
        setCooldown(60);
        setRank(Rank.RARE);
        setRequireMana(20);
        setVisible(false);
        setSkillName(SkillName.MEMORY_OF_FEET);
    }

    public MemoryOfFeet(Player p) {
        setCooldown(60);
        setRank(Rank.RARE);
        setRequireMana(20);
        setVisible(false);
        setSkillName(SkillName.MEMORY_OF_FEET);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getMoveCount() >= 20000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "20000블럭 이상을 이동했다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;

        if (ready) {
            if (!(loc == null)) {
                rp.getPlayer().teleport(loc);
                cooldown(getCooldown(), this);
            }
            return;
        }
        Player p = rp.getPlayer();
        loc = p.getLocation();
        p.sendMessage("§f[RTRPG] 마킹되었습니다 .");
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> ready = true, 10 * 20L);
    }

    public void cancelByAttacked() {
        ready = false;
        loc = null;
    }

    public boolean isReady() {
        return ready;
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
