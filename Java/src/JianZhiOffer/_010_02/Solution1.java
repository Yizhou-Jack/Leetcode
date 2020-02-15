package JianZhiOffer._010_02;

public class Solution1 {

    public static int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = numWays(7);
        System.out.println(res);
    }
}
