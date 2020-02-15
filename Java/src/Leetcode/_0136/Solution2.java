package Leetcode._0136;

import java.util.Arrays;

public class Solution2 {

    /*
    先快排，再遍历，找到不出现两次的元素即返回
    */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
