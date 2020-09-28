package jianzhioffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    LinkedList<Integer> linkedList;
    int size = 0;
    Map<Integer, Integer> map = new HashMap<>();
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedList = new LinkedList<>();
    }

    public int get(int key) {
        Integer value=map.get(key);
        if (value!=null)
        {
            linkedList.remove(new Integer(key));
            linkedList.addLast(key);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (size < capacity) {
            if (map.get(key) == null) {
                map.put(key, value);
                size++;
                linkedList.addLast(key);
            }
            if (map.get(key)!=null){
                linkedList.remove(new Integer(key));
                linkedList.addLast(key);
                map.put(key, value);
            }
        }
        if (size >= capacity) {
            if (map.get(key) == null) {
                Integer o = linkedList.removeFirst();
                map.remove(o);
                map.put(key, value);
                linkedList.addLast(key);
            }
            if (map.get(key) != null) {
                linkedList.remove(new Integer(key));
                linkedList.addLast(key);
                map.put(key, value);
            }
        }

}

}