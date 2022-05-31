package com.dpnw.rtrpg.skilleffect.impl;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.base.PluginHolder;
import com.dpnw.rtrpg.skilleffect.base.SimpleEffectImpl;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;

public class HandlePoisoning extends SimpleEffectImpl<LivingEntity> {
    public HandlePoisoning(HandleEntity handleEntity) { super(handleEntity); }

    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginHolder.getPlugin(), () -> {
            for (var e : getList()) {
                e.damage(0.75);
            }
        }, 10, 10);
    }
}
