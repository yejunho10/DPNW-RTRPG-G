package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;

/**
 * 특수한 경우가 아닌, 일반적인 상태이상의 부모 클래스입니다.
 */
public interface SimpleEffect<E extends SEntity<?>> extends EffectEntity<E>, HandleRecordEntity<E> {
}
