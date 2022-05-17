package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;
/*
Unlock : 메인퀘스트 4 완료

Effect : 받는 피해가 2 +(레벨당 0.2)% 감소합니다.

Rank : Common
Visible : true
 */
@SuppressWarnings("unused")
public class Unyieldingness extends RPassive { // todo 필드 추가
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
    public void cancel() {
    }
}