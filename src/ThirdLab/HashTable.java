package ThirdLab;

import java.util.LinkedList;

public class HashTable<K,V> {
    private LinkedList<Entry<K,V>>[] table;
    private int size;

    public HashTable(int capacity){
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
        size = 0;
    }
    private int hash(K key){
        return Math.abs(key.hashCode()% table.length);
    }
    public void put(K key, V value){
        int index = hash(key);
        if (table[index]==null){
            table[index] = new LinkedList<>();
        }
        for (Entry<K,V> entry: table[index]){
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
    public boolean remove(K key){
        int index = hash(key);
        if (table[index]!=null){
            for (Entry entry: table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
