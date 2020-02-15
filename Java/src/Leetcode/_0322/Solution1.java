package Leetcode._0322;

public class Solution1 {

    /*
    动态规划法：
    e.g. coins = [1, 2, 5], amount = 11
    转移方程：f(n)=min{f(n-1),f(n-5),f(n-11)}+1
    代码：
    int[] f = new int[amount + 1], cost;
    f[0] = 0;
    for(int i = 1; i <= amount; i++){
        cost = Integer.MAX_VALUE;
        if(i - 1 >=0） cost = Math.min(cost, f[i-1] + 1);
        if(i - 5 >=0） cost = Math.min(cost, f[i-5] + 1);
        if(i - 11 >=0） cost = Math.min(cost, f[i-11] + 1);
        f[i]=cost;
    }
    更普遍的解答就是将1 2 5改成循环
    */

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        int cost;
        for (int i = 1; i <= amount; i++) {
            cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) { //类似if(i - 1 >=0） cost = Math.min(cost, f[i-1] + 1);
                    if (dp[i-coins[j]] != Integer.MAX_VALUE) { //检查dp[i-coins[j]]的位置上是否有解
                        cost = Math.min(cost, dp[i-coins[j]] + 1);
                    }
                }
            }
            dp[i] = cost;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{10,9,2,5,3,7,101,18};
        int res = coinChange(coins, 101);
        System.out.println(res);
    }
}
