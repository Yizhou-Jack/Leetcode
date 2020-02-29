package Leetcode._0123;

public class Solution1 {

    /*
    k的取值范围为0-2，将状态转移方程罗列出来：
    dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
    dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
    dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
    作者：labuladong
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
     */

    public int maxProfit(int[] prices) {
        //由于当天的状态只和前一天有关系，那么只用储存前一天的dp数组就可以
        int dp_i10 = 0; //第一天的前一天不持有股票，不管还剩几次交易次数，利润为0
        int dp_i20 = 0; //第一天的前一天不持有股票，不管还剩几次交易次数，利润为0
        int dp_i11 = Integer.MIN_VALUE; //第一天的前一天无法持有股票，表示不可能
        int dp_i21 = Integer.MIN_VALUE; //第一天的前一天无法持有股票，表示不可能
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21+price);
            dp_i21 = Math.max(dp_i21, dp_i10-price);
            dp_i10 = Math.max(dp_i10, dp_i11+price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
}
