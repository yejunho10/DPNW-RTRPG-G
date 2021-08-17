package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.skills.skillActive.*;
import com.dpnw.rtrpg.skills.skillPassive.HugOfWind;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class Skills { //논 이벤트 해금조건을 가진 스킬
    private final Set<Skill> skills = new HashSet<>();

    public Skills(Player p) {
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            skills.add(new Sprint(p));
            skills.add(new AirSlash(p));
            skills.add(new WindSword(p));
            skills.add(new HugOfWind(p));
            skills.add(new JetStomp(p));
            skills.add(new HighExistance(p));
        }, 5L);

    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
