package Leetcode._0121;

public class Solution1 {

    /*
    经典动态回归股票问题：
    dp[x][y]：x代表第x天，y：0代表当天未持有股票，1代表当天持有股票
    以dp[i][0]为例：
    状态转移到dp[i][0]有两种情况：1. dp[i - 1][0]：前一天未持有
                              2. dp[i - 1][1] + prices[i]：前一天持有并当天卖出
    状态转移到dp[i][1]有两种情况：1. dp[i - 1][1]：前一天持有
                              2. -prices[i]：当天买入
    */

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        //0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        //1：用户手上持股所能获得的最大利润
        //注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
