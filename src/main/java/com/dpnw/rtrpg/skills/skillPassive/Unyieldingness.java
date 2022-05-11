package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class Unyieldingness extends RPassive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public Unyieldingness() {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.UNYIELDINGNESS);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 4 완료.";
    }

    @Override
    public void use(RPlayer p) {
        p.setArmor(p.getArmor() + 2);
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