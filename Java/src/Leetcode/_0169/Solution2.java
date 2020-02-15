package Leetcode._0169;

public class Solution2 {

    /*
    投票法：
    由于必定多于半数，那么将目前获取到的元素作为candidate，等于则加一，不等于则减一，到最后candidate必定会是众数
    */

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
