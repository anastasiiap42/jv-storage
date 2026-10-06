package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K newKey, V newValue) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && newKey == null)
                    || (keys[i] != null && keys[i].equals(newKey))) {
                if (values[i] != null) {
                    values[i] = newValue;
                    return;
                }
            }
        }
        if (size < DEFAULT_CAPACITY) {
            keys[size] = newKey;
            values[size] = newValue;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
