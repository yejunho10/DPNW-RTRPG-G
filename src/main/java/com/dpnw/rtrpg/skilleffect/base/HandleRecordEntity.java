package com.dpnw.rtrpg.skilleffect.base;

import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;

public interface HandleRecordEntity<E extends LivingEntity> {

    ArrayList<E> getList();

}
