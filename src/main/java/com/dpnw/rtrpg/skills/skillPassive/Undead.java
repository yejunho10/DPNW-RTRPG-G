package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class Undead extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Undead() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.UNDEAD);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인 퀘스트에서 사망했다.";
    }

    @Override
    public void use(RPlayer p) {
        p.setHealthRegen(p.getHealthRegen() + 2);
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