package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class Survivor extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Survivor() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.SURVIVOR);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인 퀘스트를 죽지 않고 깼다.";
    }

    @Override
    public void use(RPlayer p) {
        p.setArmor(p.getArmor() + 5);
        p.setcurrentManaRegen(p.getcurrentManaRegen() + 1);
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