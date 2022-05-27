package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 스태프 무기 숙련도 5 레벨 달성

Effect : 소모한 마나의 절반만큼 체력을 회복한다.

Rank : Common
Visible : true
 */
@SuppressWarnings("unused")
public class BlessingOfMana extends RPassive {
    private BukkitTask task;

    public BlessingOfMana() {
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.BLESSING_OF_MANA);
    }

    @Override
    public String skillUnlockCondition() {
        return "스태프 무기 숙련도 5 레벨 달성.";
    }

    @Override
    public void cancel() {
    }
}