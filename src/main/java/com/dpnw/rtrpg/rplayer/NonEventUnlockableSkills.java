package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.skills.skillActive.*;
import com.dpnw.rtrpg.skills.skillPassive.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class NonEventUnlockableSkills { //논 이벤트 해금조건을 가진 스킬 (Task가 존재할 경우에만 여기에 추가)
    private final Set<Skill> skills = new HashSet<>();

    public NonEventUnlockableSkills(Player p) {
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            // active
            skills.add(new Sprint(p));
            skills.add(new CosmicDiscernment(p));
            skills.add(new AirSlash(p));
            skills.add(new WindSword(p));
            skills.add(new HugOfWind(p));
            skills.add(new JetStomp(p));
            skills.add(new HighExistance(p));
            skills.add(new MemoryOfFeet(p));
            skills.add(new MeteorStrike(p));
            skills.add(new FairWind(p));
            skills.add(new Confusion(p));
            skills.add(new Dash(p));
            skills.add(new Destruction(p));
            // passive
            skills.add(new DelightofSlaughter(p));
            skills.add(new Endurance(p));
            skills.add(new Enlightenment(p));
            skills.add(new GreenBloodline(p));
            skills.add(new HardMuscle(p));
            skills.add(new HugOfWind(p));
            skills.add(new OverHeating(p));
            skills.add(new Resolution(p));
            skills.add(new Sin(p));
            skills.add(new SoulofGladiator(p));
            skills.add(new Tension(p));
            skills.add(new Viscosity(p));
        }, 5L);
    }

    public Set<Skill> getSkills() {
        return skills;
    }

}
