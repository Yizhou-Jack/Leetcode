package Leetcode._0122;

public class Solution1 {

    /*
    股票问题：与121大致相同
    由于可以多次交易，因此dp[i][1]取rest状态和dp[i-1][0]-prices[i]（当天买入状态）的最大值
    */

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }

        return dp[len-1][0];
    }
}
