package com.dpnw.rtrpg.skilleffect.api.metadata;

public interface MetaStore {

    void set(String key, Object value);

    <T> T get(String key, Class<T> type);

    boolean getBoolean(String string);

    int getInt(String String);

    float getFloat(String String);

    double getDouble(String String);

    long getLong(String String);

    String getString(String String);

    Object getObject(String String);

    void remove(String key);

}