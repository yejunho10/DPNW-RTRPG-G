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
public class Undead extends RPassive {

    public Undead() {
        setRank(Rank.COMMON);
        setVisible(false);
        setSkillName(SkillName.UNDEAD);
        setIncreaseManaRegen(1);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인 퀘스트에서 사망했다.";
    }

    @Override
    public void cancel() {
    }
}