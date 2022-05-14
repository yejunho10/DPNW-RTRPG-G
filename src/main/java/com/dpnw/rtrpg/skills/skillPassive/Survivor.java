package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 메인 퀘스트를 죽지 않고 깼다.

Effect : 초당 마나 재생 1, 방어력 5 증가

Rank : common
Visable : false
 */
@SuppressWarnings("unused")
public class Survivor extends RPassive {

    public Survivor() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.SURVIVOR);
        setIncreaseManaRegen(1);
        setIncreaseArmor(5);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인 퀘스트를 죽지 않고 깼다.";
    }

    @Override
    public void cancel() {
    }
}