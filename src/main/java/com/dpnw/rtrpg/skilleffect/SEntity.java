package com.dpnw.rtrpg.skilleffect;

import org.bukkit.entity.LivingEntity;

public interface SEntity<E extends LivingEntity> extends SkillCaster {

    E getEntity();

}
