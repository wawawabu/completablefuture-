package it.com.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUDemo<K,V> extends LinkedHashMap<K,V>{
    private int capacity;
    public LRUDemo(int capacity){
        super(capacity,0.75F,false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(5,4);
        hashMap.put(6,5);
        hashMap.put(1,2);
        System.out.println(hashMap);

    }
}
