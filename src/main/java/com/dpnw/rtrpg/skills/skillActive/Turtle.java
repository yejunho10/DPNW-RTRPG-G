package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class Turtle extends RActive {
    public Turtle() {
        setCooldown(37);
        setRank(Rank.UNCOMMON);
        setRequireMana(10);
        setDuration(5);
        setVisible(false);
        setSkillName(SkillName.TURTLE);
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.setArmor(p.getArmor() + 50 + (p.getLevel() * 0.5));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> p.setArmor(p.getArmor() - 50 + (p.getLevel() * 0.5)), (long) (getDuration() * 20));
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {

    }
}