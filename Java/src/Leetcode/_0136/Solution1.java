package Leetcode._0136;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution1 {

    /*
    利用hashmap储存键值对，出现两次即remove
    */

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }
        Iterator<Integer> iter = map.keySet().iterator();
        return iter.next();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,5};
        int res = singleNumber(nums);
        System.out.println(res);
    }
}
