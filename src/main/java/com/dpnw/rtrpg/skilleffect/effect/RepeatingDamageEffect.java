package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.api.PluginHolder;
import com.dpnw.rtrpg.skilleffect.base.RecordCastedEffect;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Delegate;
import org.bukkit.Bukkit;

@Getter
@AllArgsConstructor
public class RepeatingDamageEffect {

    @Delegate
    private final RecordCastedEffect<CastedEffect<SEntity<?>>> effect;

    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(PluginHolder.getPlugin(), () -> {
            for (var e : getList()) {
                e.getEntity().getBukkit().damage(0.75);
            }
        }, 10, 10);
    }

}
