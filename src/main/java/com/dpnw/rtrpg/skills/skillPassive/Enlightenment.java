package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 2시간 동안 가만히 있었다.

Effect : 초당 마나 회복량이 1 증가한다. 모든 스킬의 쿨타임이 1 +(레벨당 0.05)초 감소한다.

Rank : Uncommon
Visable : false
 */
@SuppressWarnings("unused")
public class Enlightenment extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Enlightenment(RPlayer rp) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.ENLIGHTENMENT);
        setIncreaseManaRegen(1);
        setDecreaseCooldown(1 + rp.getLevel() * 0.05);
    }

    public Enlightenment() {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.ENLIGHTENMENT);
        setIncreaseManaRegen(1);
        setDecreaseCooldown(1 + 0.05);
    }

    public Enlightenment(Player p) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.ENLIGHTENMENT);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        setIncreaseManaRegen(1);
        setDecreaseCooldown(1 + cp.getLevel() * 0.05);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        loc = p.getLocation();
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            Location pl = p.getLocation();
            double px = pl.getX();
            double py = pl.getY();
            double pz = pl.getZ();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            if (px == x && py == y && pz == z) {
                if (timer >= 7200) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                } else {
                    timer++;
                }
            } else {
                timer = 0;
            }
            loc = pl;
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "2시간 동안 가만히 있었다.";
    }

    @Override
    public void use(RPlayer p) {
        p.setManaRegen(p.getcurrentManaRegen() + 1);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            timer = 0;
            loc = null;
        } catch (Exception ignored) {
        }
    }
}