package _0279;

public class Solution1 {

    /*
    动态规划解法：
    # dp[i]：表示完全平方数和为i的 最小个数
    # 初始状态dp[i]均取最大值i，即1+1+...+1，i个1; dp[0] = 0
    # dp[i] = min(dp[i], dp[i-j*j]+1)，其中, j是平方数, j=1~k,其中k*k要保证 <= i
    # 意思就是：完全平方数和为i的 最小个数 等于 当前完全平方数和为i的 最大个数（也就是i）
    #   与 （完全平方数和为 i - j * j 的 最小个数 + 完全平方数和为 j * j的 最小个数）
    #   可以看到 dp[j*j] 是等于1的
    # 以dp[8]为例，dp[8]首先更新为dp[7]+1=5，再更新为dp[4]+1=2
    */

    public static int numSquares(int n) {
        int[] dp = new int[n + 1]; //默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; //最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); //动态转移方程
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }
}
