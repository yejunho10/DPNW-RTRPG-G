package com.dpnw.rtrpg.skilleffect.impl;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.base.PluginHolder;
import com.dpnw.rtrpg.skilleffect.base.SimpleEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;

public class HandlePoisoning extends SimpleEffectImpl<SEntity<?>> {
    public HandlePoisoning(HandleEntity handleEntity) { super(handleEntity); }

    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginHolder.getPlugin(), () -> {
            for (var e : getList()) {
                e.getEntity().getEntity().damage(0.75);
            }
        }, 10, 10);
    }

}
