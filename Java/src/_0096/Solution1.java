package _0096;

public class Solution1 {

    /*
    结果是累加所有数字为顶的结果之和；构成不同子树的数量与序列的内容无关，只和序列的长度有关
    (某个顶的index为i)，此树的结果为dp[n]=sumToN(F(i,n)); F(i,n)=dp[i-1]*dp[n-i]
    */

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
