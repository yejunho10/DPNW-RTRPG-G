package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;

@RequiredArgsConstructor
abstract public class SimpleEffectImpl<E extends LivingEntity> extends HandleListener implements SimpleEffect<E> {
    @Getter
    public final HandleEntity handleEntity;
    @Getter
    public ArrayList<E> list = new ArrayList<>();

}
