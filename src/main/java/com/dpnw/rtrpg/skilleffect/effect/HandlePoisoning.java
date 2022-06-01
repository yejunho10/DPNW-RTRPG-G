package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.PluginHolder;
import com.dpnw.rtrpg.skilleffect.base.SimpleEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.Bukkit;

public class HandlePoisoning extends SimpleEffectImpl<SEntity<?>> {
    public HandlePoisoning(HandleEntity handleEntity) { super(handleEntity); }

    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginHolder.getPlugin(), () -> {
            for (var e : getList()) {
                e.getEntity().getBukkit().damage(0.75);
            }
        }, 10, 10);
    }

}
