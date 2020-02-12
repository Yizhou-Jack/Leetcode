package _0560;

import java.util.HashMap;

public class Solution2 {

    /*
    1.每次求和
    2.求和后看看当前的和和目标的期望差
    3.在map中找到求和之前的所有集合中有没有可以满足目标差的value
    4.看看是几个
    */

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
