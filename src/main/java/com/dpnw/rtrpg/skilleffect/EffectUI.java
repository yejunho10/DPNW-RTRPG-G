package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.base.HandleListener;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import org.bukkit.event.EventHandler;

public class EffectUI extends HandleListener {

    @EventHandler
    public void onRelease(EffectReleaseEvent event) {
        event.getEntity().getEntity()
                .sendMessage(event.getEffect().getClass().getSimpleName() + " effect released!");
    }

    @EventHandler
    public void onBegin(EffectBeginEvent event) {
        event.getEntity().getEntity()
                .sendMessage(event.getEffect().getClass().getSimpleName() + " effect began!");
    }

}