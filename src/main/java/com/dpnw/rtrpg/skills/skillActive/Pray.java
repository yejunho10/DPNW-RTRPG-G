package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 스태프 무기 숙련도 15 레벨 달성

Use : 시전시 바라보고 있는 아군의 체력을 50 +(lv* 2)만큼 회복시킨다. 만약 대상이 적일 경우 동일한 수치만큼 피해를 주고 준 피해만큼 체력을 회복한다.

Damage : 50 +(lv *2)
MaxTargetRange : 15
Cooldown : 5
RequireMana : 50
Rank : Common
Visible : true
 */
public class Pray extends RActive {
    private BukkitTask task;

    public Pray() {
        setDamage(50);
        setCooldown(5);
        setRank(Rank.COMMON);
        setRequireMana(50);
        setRange(15);
        setVisible(true);
        setSkillName(SkillName.PRAY);
    }

    @Override
    public String skillUnlockCondition() {
        return "스태프 무기 숙련도 15 레벨 달성.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        //todo logic...
        cooldown(this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}