package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;

import java.util.ArrayList;

public interface RecordCastedEffect<E extends SEntity<?>> {

    ArrayList<CastedEffect<E>> getList();

}
