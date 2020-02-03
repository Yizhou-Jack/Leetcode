package _0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        //在ArrayList末尾添加一个数的时间复杂度为O(1)
        map.put(val, list.size());
        list.add(val);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index, num;
        if (!map.containsKey(val)) return false;
        //由于在ArrayList中间删除一个元素的时间复杂度为O(N)
        //因此用末尾的数替换掉需要删除的数(根据map得到索引,平均时间复杂度O(1))
        //再删除掉末尾的数(时间复杂度O(1))
        index = map.get(val);
        num = list.get(size - 1);
        list.set(index, num);
        map.put(num, index);
        map.remove(val);
        list.remove(size - 1);
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index;
        //ArrayList根据索引访问时间复杂度为O(1)
        index = (int)(size * Math.random());
        return list.get(index);
    }

}
