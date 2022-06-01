package com.dpnw.rtrpg.skilleffect.entity;

import org.bukkit.entity.LivingEntity;

public interface SEntity<E extends LivingEntity> extends SkillCaster {

    E getBukkit();

}
