package com.dpnw.rtrpg.skills.utils;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.obj.Skill;
import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class ActivateBuffs { //todo 버프류 관련 지급

    public static void buff(CraftRPlayer cp, Skill skill, double duration) { //자신에게 부여
        //버프 바로 지급
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> { //버프 제거 (타임아웃)

        }, (long) duration * 20);
    }
}
