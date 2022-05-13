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
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
/*
Unlock : 20000M 이상 걸을 시

Effect : 자신이 서 있는 위치에 마킹할 수 있고, 10초의 시전시간 후 마킹한 위치로 순간이동 할 수 있다. 시전시간 중 피해를 입으면 시전이 해제된다.

Require Mana : 20
Cooldown : 60 (1m)
Rank : Rare
Visable : false
 */
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
            if (cp == null) return;
            if (cp.getMoveCount() >= 20000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 10L, 20L);
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
