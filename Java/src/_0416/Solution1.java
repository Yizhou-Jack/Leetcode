package _0416;

public class Solution1 {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum%2 != 0) return false;

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
                if (dp[nums.length][sum] != 0) return true;
            }
        }
        //System.out.println(dp[nums.length][sum]);
        return dp[nums.length][sum] != 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}
