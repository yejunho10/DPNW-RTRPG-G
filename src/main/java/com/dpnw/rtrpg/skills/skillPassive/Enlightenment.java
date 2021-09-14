package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class Enlightenment extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Enlightenment() {
        setRank(Rank.UNCOMMON);
        setVisible(true);
        setSkillName(SkillName.ENLIGHTENMENT);
    }

    public Enlightenment(Player p) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.ENLIGHTENMENT);
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