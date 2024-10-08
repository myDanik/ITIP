package ThirdLab;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] table;
    private int size;

    public HashTable(int capacity){
        table = new LinkedList[capacity];
        size = 0;
    }
    private int hash(String key){
        return Math.abs(key.hashCode()% table.length);
    }
    public void put(String key, Integer value){
        int index = hash(key);
        if (table[index]==null){
            table[index] = new LinkedList<>();
        }
        for (Entry entry: table[index]){
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }
    public Integer get(String key){
        int index = hash(key);
        if (table[index] != null){
            for (Entry entry: table[index]){
                if (entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }
    public boolean remove(String key){
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
    private static class Entry {
        private String key;
        private Integer value;

        public Entry(String key, int value){
            this.key = key;
            this.value = value;
        }
        public String getKey(){
            return key;
        }
        public Integer getValue(){
            return value;
        }
        public void setValue(Integer value){
            this.value = value;
        }
    }

}
