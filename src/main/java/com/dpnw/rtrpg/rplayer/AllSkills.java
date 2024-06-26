package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.skills.skillActive.*;
import com.dpnw.rtrpg.skills.skillPassive.*;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class AllSkills {
    private static final Set<Skill> skills = new HashSet<>();

    public static void init() {
        skills.clear();
        skills.add(new AirSlash());
        skills.add(new Cutting());
        skills.add(new Immovable());
        skills.add(new Sprint());
        skills.add(new Turtle());
        skills.add(new WindSword());
        skills.add(new DoubleJump());
        skills.add(new Endurance());
        skills.add(new HugOfWind());
        skills.add(new Mementomori());
        skills.add(new Thanatophobia());
        skills.add(new HighExistance());
        skills.add(new CosmicDiscernment());
        skills.add(new JetStomp());
        skills.add(new Noob());
        skills.add(new MemoryOfFeet());
        skills.add(new WaterBall());
        skills.add(new WindStrike());
        skills.add(new FireBall());
        skills.add(new FireRing());
        skills.add(new PassingAndHit());
        skills.add(new FlingUP());
        skills.add(new Exacting());
        skills.add(new WheelAttack());
        skills.add(new SpinAttack());
        skills.add(new Unyieldingness());
        skills.add(new Survivor());
        skills.add(new Undead());
        skills.add(new Destruction());
        skills.add(new FairWind());
        skills.add(new DelightofSlaughter());
        skills.add(new Enlightenment());
        skills.add(new GreenBloodline());
        skills.add(new HardMuscle());
        skills.add(new OverHeating());
        skills.add(new Resolution());
        skills.add(new Sin());
        skills.add(new SoulofGladiator());
        skills.add(new Tension());
        skills.add(new Viscosity());
        skills.add(new Confusion());
    }

    public static Skill getSkillFromName(SkillName name) {
        for (Skill s : skills) {
            if (s.getSkillName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public static Set<Passive> getPassiveList() {
        Set<Passive> passiveList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Passive)) continue;
            passiveList.add((Passive) s);
        }
        return passiveList;
    }

    public static Set<Passive> getVisiblePassiveList() {
        Set<Passive> passiveList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Passive)) continue;
//            if (!s.isVisible()) continue;
            passiveList.add((Passive) s);
        }
        return passiveList;
    }

    public static Set<Passive> getVisiblePassiveList(Player p) {
        Set<Passive> passiveList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Passive)) continue;
//            if (!s.isVisible()) continue;
            passiveList.add((Passive) s);
        }
//        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
//        passiveList.addAll(cp.getPassiveList().values());
        return passiveList;
    }

    public static Set<Active> getActiveList() {
        Set<Active> activeList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Active)) continue;
            activeList.add((Active) s);
        }
        return activeList;
    }

    public static Set<Active> getVisibleActiveList() {
        Set<Active> activeList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Active)) continue;
//            if (!s.isVisible()) continue;
            activeList.add((Active) s);
        }
        return activeList;
    }

    public static Set<Active> getVisibleActiveList(Player p) {
        Set<Active> activeList = new HashSet<>();
        for (Skill s : skills) {
            if (!(s instanceof Active)) continue;
//            if (!s.isVisible()) continue;
            activeList.add((Active) s);
        }
//        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
//        activeList.addAll(cp.getActiveList().values());
        return activeList;
    }
}
