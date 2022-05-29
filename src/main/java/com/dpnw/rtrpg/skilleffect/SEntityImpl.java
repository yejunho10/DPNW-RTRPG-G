package com.dpnw.rtrpg.skilleffect;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;

@RequiredArgsConstructor
public class SEntityImpl extends HashMap<String, Object> implements SEntity<LivingEntity> {

    @Getter
    private final LivingEntity entity;

}
