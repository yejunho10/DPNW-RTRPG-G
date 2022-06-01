package com.dpnw.rtrpg.skilleffect.api.metadata;

import java.util.HashMap;

public class MetaStoreImpl implements MetaStore {

    HashMap<String, Object> metaStore = new HashMap<>();

    private Object get(String key) {
        return metaStore.getOrDefault(key, null);
    }

    @Override
    public void set(String key, Object value) {
        metaStore.put(key, value);
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return (T) get(key);
    }

    @Override
    public boolean getBoolean(String string) {
        return (boolean) get(string);
    }

    @Override
    public int getInt(String String) {
        return (int) get(String);
    }

    @Override
    public float getFloat(String String) {
        return (float) get(String);
    }

    @Override
    public double getDouble(String String) {
        return (double) get(String);
    }

    @Override
    public long getLong(String String) {
        return (long) get(String);
    }

    @Override
    public String getString(String String) {
        return (String) get(String);
    }

    @Override
    public Object getObject(String String) {
        return get(String);
    }

    @Override
    public void remove(String key) {
        metaStore.remove(key);
    }

}