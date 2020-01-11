package _0070;

public class Solution {

    /*
    动态规划方法解爬楼梯问题：
    到达第i阶的方法总数就是到第i−1阶和第i−2阶的方法数之和，因此我们可以维护一个dp数组，逐步得出dp[n]的数字大小。
    */

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = climbStairs(5);
        System.out.println(res);
    }
}
