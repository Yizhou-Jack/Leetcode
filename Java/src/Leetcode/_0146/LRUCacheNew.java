package Leetcode._0146;

import structures.DoubleList;
import structures.DoubleNode;

import java.util.HashMap;

public class LRUCacheNew {

    private HashMap<Integer, DoubleNode> map;
    private DoubleList cache;
    private int cap;

    public LRUCacheNew(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public void put(int key, int val) {
        DoubleNode x = new DoubleNode(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                DoubleNode last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
}
