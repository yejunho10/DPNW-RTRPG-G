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

public class AirSlash extends RActive {
    private BukkitTask task;

    public AirSlash() {
        setDamage(120);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(40);
        setRange(20);
        setVisible(true);
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
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getMoveCount() >= 5000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    /*
    Use : 시전시 전방을 베어가르며 날아가는 칼바람을 발사합니다. 칼바람은 적을 관통하며, 닿을시 120 +(레벨당 2)의 피해를 입힙니다.
     */
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
