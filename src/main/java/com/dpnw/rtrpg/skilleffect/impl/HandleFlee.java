package com.dpnw.rtrpg.skilleffect.impl;

import com.dpnw.rtrpg.skilleffect.HandleEntity;
import com.dpnw.rtrpg.skilleffect.base.SimpleEffectImpl;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HandleFlee extends SimpleEffectImpl<LivingEntity> {
    public HandleFlee(HandleEntity handlePlayer) { super(handlePlayer); }

    @Override
    public void addEffect(LivingEntity entity, int tick) {
        super.addEffect(entity, tick);
        entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, tick, 1));
        //todo implement 강제로 플레이어로부터 멀어짐. 조작 불가.
        // STOPSHIP: 2022-05-29 브루스가 작업하다 말았음
    }

}
