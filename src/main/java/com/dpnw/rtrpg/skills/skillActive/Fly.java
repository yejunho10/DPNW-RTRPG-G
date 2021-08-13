package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Fly extends RActive {
    private int timer = 0;
    private BukkitTask task;

    public Fly() {
        setCooldown(60);
        setRank(Rank.UNCOMMON);
        setRequireMana(10);
        setDuration(3);
        setVisible(false);
        setSkillName(SkillName.FLY);
    }

    public Fly(Player p) {
        setCooldown(60);
        setRank(Rank.UNCOMMON);
        setRequireMana(10);
        setDuration(7);
        setVisible(false);
        setSkillName(SkillName.FLY);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (p.getLocation().clone().add(0, -3, 0).getBlock().getType() == Material.AIR) {
                if (timer >= 3) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                    return;
                }
                timer++;
            } else {
                timer = 0;
            }
        }, 0L, 20L);
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().setAllowFlight(true);
        p.getPlayer().setFlying(true);
        p.getPlayer().getWorld().playSound(p.getPlayer().getLocation(), Sound.ENTITY_EGG_THROW, 0.5f, 1.4f);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            p.getPlayer().setFlying(false);
            p.getPlayer().setAllowFlight(false);
        }, (long) ((getDuration() + ((p.getLevel() == 0? 1 : p.getLevel()) * 0.07)) * 20));
        System.out.println(((getDuration() + ((p.getLevel() == 0? 1 : p.getLevel()) * 0.07)) * 20));
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            timer = 0;
        } catch (Exception ignored) {
        }
    }
}
