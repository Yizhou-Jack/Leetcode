package JianZhiOffer._014_01;

public class Solution2 {

    /*
    第一个循环i：i长度绳子的最大值
    第二个循环：剪的长度
    当i = 4, j = 1时表示长度为4，剪成1，3的情况。而我们知道长度为1和3的最大值，只要将他们相乘即可。
    当i = 4, j = 2时表示长度为4，剪成2，2的情况。而我们知道长度为2和2的最大值，只要将他们相乘即可。
     */

    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                max = Math.max(max, dp[j] * dp[i-j]);
                dp[i] = max;
            }
        }

        return dp[n];
    }
}
