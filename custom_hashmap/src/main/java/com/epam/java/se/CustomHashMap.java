package com.epam.java.se;

import java.util.*;

/**
 * Created by Мария on 25.03.2017.
 */
public class CustomHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private CustomEntry<K, V>[] buckets = new CustomEntry[DEFAULT_CAPACITY];

    @Override
    public int size() {
        int count = 0;
        for (CustomEntry<K, V> n : buckets) {
            if (n != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (CustomEntry<K, V> n : buckets) {
            if (n != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);

        int hash = hashCode((K) key);
        CustomEntry<K, V> bucket = buckets[hash];
        if (bucket != null) {
            return bucket.key.equals(key);
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                CustomEntry<K, V> currentBucket = buckets[i];
                while (currentBucket != null) {
                    if (currentBucket.getValue().equals(value)) {
                        return true;
                    }
                    currentBucket = currentBucket.next();
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);

        int hash = hashCode(key);
        CustomEntry<K, V> currentEntry = buckets[hash];

        if (currentEntry != null) {
            boolean finished = false;

            while (!finished) {
                if (key.equals(currentEntry.getKey())) {
                    currentEntry.setValue(value);
                    finished = true;
                } else if (currentEntry.next() == null) {
                    currentEntry.setNext(new CustomEntry<>(key, value));
                    finished = true;
                }
                currentEntry = currentEntry.next();
            }
        } else {
            buckets[hash] = new CustomEntry<>(key, value);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private int hashCode(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


    private class CustomEntry<K, V> implements Iterator<CustomEntry<K, V>> {

        private final K key;
        private V value;
        private CustomEntry<K, V> next = null;

        CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public CustomEntry<K, V> next() {
            return this.next;
        }

        void setNext(CustomEntry<K, V> next) {
            this.next = next;
        }
    }
}