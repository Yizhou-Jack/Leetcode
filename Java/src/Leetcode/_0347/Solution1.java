package Leetcode._0347;

import java.util.*;

public class Solution1 {

    /*
    sort Map中的值，返回最大的k个value
    */

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++num);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            res.add(entry.getKey());
            if (++i == k) break;
        }
        return res;
    }
}
