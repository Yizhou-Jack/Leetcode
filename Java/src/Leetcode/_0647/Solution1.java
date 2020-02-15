package Leetcode._0647;

public class Solution1 {

    public static int countSubstrings(String s) {
        int len = s.length();
        int res = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = countSubstrings("aaa");
        System.out.println(res);
    }

}
