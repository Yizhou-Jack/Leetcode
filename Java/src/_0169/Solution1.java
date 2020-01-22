package _0169;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /*
    维护一个哈希表
    */

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(nums[i], 0);
            num++;
            if (num > len/2) return nums[i];
            map.put(nums[i], num);
        }
        return 0;
    }

}
