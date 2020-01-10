package _0053;

public class Solution {

    /*
    动态规划方法：
    维护一个dp数组：dp的每个位置i就是当前到nums[i]的max值（要么是之前的dp[i-1]+nums[i]很ok，要么是nums[i]自己就比前面的大（由于前面是负数））
    每次更新完dp[i]就更新max
    */

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,2,4,-5,1,2,8,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
