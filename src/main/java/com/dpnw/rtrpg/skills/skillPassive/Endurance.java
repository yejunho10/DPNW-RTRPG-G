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
public class Endurance extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Endurance() {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.ENDURANCE);
    }

    public Endurance(Player p) {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.ENDURANCE);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            Location pl = p.getLocation();
            double px = pl.getX();
            double py = pl.getY();
            double pz = pl.getZ();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            if (px == x && py == y && pz == z) {
                if (timer >= 1800) {
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
        p.setManaRegen(p.getcurrentManaRegen() + 0.1);
    }

    @Override
    public void cancel() {
        try{
            task.cancel();
            timer = 0;
            loc = null;
        }catch (Exception ignored){}
    }
}