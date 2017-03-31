package com.epam.java.se;

import java.util.*;

/**
 * Class represents an implementation of Custom HashMap with
 * limited size. A map cannot contain duplicate keys. Keys are not
 * sorted. Values are put in this map by hash-function. If collision
 * occurred key-value pairs are lined up in the chain in each bucket.
 * <p>
 * Created by Мария on 25.03.2017.
 */
public class CustomHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private CustomEntry<K, V>[] buckets = new CustomEntry[DEFAULT_CAPACITY];
    private int size = 0;

    /**
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param key key whose presence in this map is to be tested
     * @return true if this map contains a mapping for
     * the specified key. Key location is calculated by hash-function.
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);

        int hash = hashCode((K) key);
        CustomEntry<K, V> bucket = buckets[hash];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return true;
            } else {
                bucket = bucket.next();
            }
        }
        return false;
    }

    /**
     * @param value value whose presence in this map is to be tested,
     *              allows null values. Searches value even if collisions occurred.
     * @return true specified value is presented in one or more keys
     */
    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                CustomEntry<K, V> currentBucket = buckets[i];
                while (currentBucket != null) {
                    if (currentBucket.getValue() == null) {
                        if (value == null) {
                            return true;
                        }
                    } else if (currentBucket.getValue().equals(value)) {
                        return true;
                    }
                    currentBucket = currentBucket.next();
                }
            }
        }
        return false;
    }

    /**
     * @param key the key whose associated value is to be returned
     * @return value to which the specified key is or null
     * if this map contains no mapping for the key.
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);

        int hash = hashCode((K) key);
        CustomEntry<K, V> currentEntry = buckets[hash];

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                return currentEntry.getValue();
            }
            currentEntry = currentEntry.next();
        }
        return null;
    }

    /**
     * Put key-value pairs in this map. If collision occurred
     * key-value pairs are lined up in the chain in each bucket.
     * Allows null values. If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.
     *
     * @param key   key with which the specified value is to be associated.
     * @param value value to be associated with the specified key.
     * @return the previous value associated with key, or
     * null if there was no mapping for key.
     * @throws NullPointerException if the specified key is null.
     */
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
                    return currentEntry.getValue();
                } else if (currentEntry.next() == null) {
                    currentEntry.setNext(new CustomEntry<>(key, value));
                    size++;
                    finished = true;
                }
                currentEntry = currentEntry.next();
            }
        } else {
            buckets[hash] = new CustomEntry<>(key, value);
            size++;
        }
        return null;
    }

    /**
     * Removes key-value pairs in this map. If there are any collisions
     * target key-values will be removed and other pairs will be rebuild.
     *
     * @param key key whose mapping is to be removed from the map.
     * @return the previous value associated with key, or
     * null if there was no mapping for key.
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key);

        int hash = hashCode((K) key);

        CustomEntry<K, V> previousEntry = null;
        CustomEntry<K, V> currentEntry = buckets[hash];

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                if (previousEntry == null) {
                    buckets[hash] = buckets[hash].next();
                    size--;
                } else {
                    previousEntry.next().setValue(currentEntry.getValue());
                    size--;
                    return previousEntry.getValue();
                }
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.next();
        }
        return null;
    }

    /**
     * Clears entire map.
     */
    @Override
    public void clear() {
        size = 0;
        buckets = new CustomEntry[DEFAULT_CAPACITY];
    }

    /**
     * @param key to calculate by hash-function
     *            position of key in bucket.
     * @return position in bucket.
     */
    private int hashCode(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    /**
     * Copies all of the mappings from the specified map to this map
     *
     * @param m - mappings from specified map to be stored in this map
     * @throws NullPointerException if specified map or it's key is null.
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Objects.requireNonNull(m);
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Returns a Set of the keys contained in this map.
     * Changes to the map are reflected in the set, and vice-versa.
     * Set supports iterate, remove, clear operations.
     * Set doesn't support add operations.
     * @return a set of the keys contained in this map
     */
    @Override
    public Set<K> keySet() {
        return new CustomKeySet();
    }

    /**
     * Returns a Collection of values contained in this map.
     * Changes to the map are reflected in the set, and vice-versa.
     * Collection supports iterate, remove, clear operations.
     * Collection doesn't support add operations.
     * @return a collection of values contained in this map
     */
    @Override
    public Collection<V> values() {
        return new CustomValueCollection();
    }

    /**
     * Returns a Set of the key-value pairs contained in this map.
     * Changes to the map are reflected in the set, and vice-versa.
     * Set supports iterate, remove, clear operations.
     * Set doesn't support add operations.
     * @return a set of the key-value pairs contained in this map
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return new CustomEntrySet();
    }


    /**
     * Inner class that represents single entry of key-value pair in
     * array of buckets.
     *
     * @param <K> key
     * @param <V> value
     */
    private class CustomEntry<K, V> implements Map.Entry<K, V>{

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

        public V setValue(V value) {
            V prev = this.value;
            this.value = value;
            return prev;
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

    private class CustomKeySet extends AbstractSet<K> {

        @Override
        public Iterator<K> iterator() {
            return new IteratorForKeySet();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean contains(Object o) {
            return CustomHashMap.this.containsKey(o);
        }

        @Override
        public boolean remove(Object o) {
            return CustomHashMap.this.remove(o) != null;
        }

        @Override
        public void clear() {
            CustomHashMap.this.clear();
        }
    }

    private class CustomValueCollection extends AbstractCollection<V> {
        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean contains(Object o) {
            return CustomHashMap.this.containsValue(o);
        }

        @Override
        public Iterator<V> iterator() {
            return new IteratorForValueCollection();
        }

        @Override
        public void clear() {
            CustomHashMap.this.clear();
        }
    }

    private class CustomEntrySet extends AbstractSet<Entry<K, V>> {
        @Override
        public boolean remove(Object o) {
            return CustomHashMap.this.remove(((CustomEntry<K, V>) o).key) != null;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof CustomEntry) {
                CustomEntry<K, V> inputEntry = (CustomEntry<K, V>) o;
                K inputEntryKey = inputEntry.getKey();

                CustomEntry<K, V> entryToCompare = new CustomEntry<>(inputEntryKey, CustomHashMap.this.get(inputEntryKey));

                return entryToCompare.equals(inputEntry);
            }
            return false;
        }

        @Override
        public void clear() {
            CustomHashMap.this.clear();
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new IteratorForEntrySet();
        }

        @Override
        public int size() {
            return size;
        }
    }

    private abstract class CustomIterator implements Iterator {
        protected CustomEntry<K, V>[] entries = new CustomEntry[size];
        protected int cursor = 0;

        public CustomIterator() {
            init();
            cursor = -1;
        }

        @Override
        public boolean hasNext() {
            return cursor < entries.length - 1;
        }

        @Override
        public void remove() {
            CustomHashMap.this.remove(entries[cursor].key);
        }

        private void init() {
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    CustomEntry<K, V> currentEntry = buckets[i];
                    while (currentEntry != null) {
                        entries[cursor] = currentEntry;
                        cursor++;
                        currentEntry = currentEntry.next();
                    }
                }
            }
        }
    }

    private class IteratorForKeySet extends CustomIterator {
        @Override
        public Object next() {
            return entries[++cursor].key;
        }
    }

    private class IteratorForValueCollection extends CustomIterator {
        @Override
        public Object next() {
            return entries[++cursor].value;
        }
    }

    private class IteratorForEntrySet extends CustomIterator {
        @Override
        public Object next() {
            return entries[++cursor];
        }
    }
}
