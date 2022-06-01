package com.dpnw.rtrpg.skilleffect.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtil {
    public static UUID fastRandomUUID() {
        return new UUID(new Random().nextLong(), new Random().nextLong());
    }
}
