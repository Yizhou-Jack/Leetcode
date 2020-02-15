package Leetcode._0494;

public class Solution1 {

    /*
    dp[i][j]表示前i个数和为j的方法数为dp[i][j]
    dp[i][j]=dp[i-1][i-nums[i-1]] + dp[i-1][i+nums[i-1]];
    */

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (S < -sum || S > sum) return 0;

        int[][] dp = new int[nums.length + 1][2*sum + 1];
        dp[0][0+sum] = 1; //0个数字合为0的方法数为1。0+sum代表和为0, 0代表和为-sum
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2*sum + 1; j++) {
                if (j + nums[i-1] < 2*sum + 1) { //判断加上nums[i-1]是否超限，超限的话不合理需要排除
                    dp[i][j] += dp[i-1][j + nums[i-1]]; //递推式：每次都给dpij累加
                }
                if (j - nums[i-1] >= 0) {
                    dp[i][j] += dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum+S];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int res = findTargetSumWays(nums, 3);
        System.out.println(res);
    }

}
