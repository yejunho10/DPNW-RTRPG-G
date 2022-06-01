package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import lombok.Getter;

import java.util.ArrayList;

public class RecordCastedEffectImpl<E extends CastedEffect<?>> implements RecordCastedEffect<E> {
    @Getter
    private final ArrayList<E> list = new ArrayList<>();
}
