package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class WindSword extends RActive {
    private BukkitTask task;

    public WindSword() {
        setDamage(175);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(65);
        setRange(7);
        setVisible(false);
        setSkillName(SkillName.WIND_SWORD);
    }

    public WindSword(Player p) {
        setDamage(175);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(65);
        setRange(7);
        setVisible(false);
        setSkillName(SkillName.WIND_SWORD);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer)RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getMoveCount() >= 10000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        //todo logic...
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