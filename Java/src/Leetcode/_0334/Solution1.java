package Leetcode._0334;

import java.util.Arrays;

public class Solution1 {

    /*
    O(N^2)不怎么样的解法
    */

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;

        int[] dp = new int[len];
        dp[len-2] = (nums[len-1] > nums[len-2]) ? 1 : 0;
        for (int i = len-3; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (dp[j] == 1 && nums[i] < nums[j]) return true;
                if (dp[i] != 1 && nums[i] < nums[j]) dp[i] = 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,0,0,10,0,0,1000};
        boolean res = increasingTriplet(nums);
        System.out.println(res);
    }
}
