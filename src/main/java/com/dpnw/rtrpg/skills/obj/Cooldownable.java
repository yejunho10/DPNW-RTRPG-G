package com.dpnw.rtrpg.skills.obj;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class Cooldownable {
    public void cooldown(double time, @NotNull Skill skill) {
        skill.setCooldown(true);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> skill.setCooldown(false), (long) (time* 20L));
    }
}
