package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.skills.skillActive.AirSlash;
import com.dpnw.rtrpg.skills.skillActive.Fly;
import com.dpnw.rtrpg.skills.skillActive.Sprint;
import com.dpnw.rtrpg.skills.skillActive.WindSword;
import com.dpnw.rtrpg.skills.skillPassive.HugOfWind;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class Skills { //논 이벤트 해금조건을 가진 스킬
    private final Set<Skill> skills = new HashSet<>();
    private Fly fly;
    private Sprint sprint;
    private AirSlash airSlash;
    private WindSword windSword;
    private HugOfWind hugOfWind;

    public Skills(Player p) {
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            this.fly = new Fly(p);
            this.sprint = new Sprint(p);
            this.airSlash = new AirSlash(p);
            this.windSword = new WindSword(p);
            this.hugOfWind = new HugOfWind(p);
            init();
        }, 5L);

    }

    private void init() {
        skills.add(fly);
        skills.add(sprint);
        skills.add(airSlash);
        skills.add(windSword);
        skills.add(hugOfWind);
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public Fly getFly() {
        return fly;
    }


    public Sprint getSprint() {
        return sprint;
    }

    public AirSlash getAirSlash() {
        return airSlash;
    }

    public WindSword getWindSword() {
        return windSword;
    }

    public HugOfWind getHugOfWind() {
        return hugOfWind;
    }
}
