package Leetcode._0221;

public class Solution1 {

    /*
    动态规划解法：
    创建一个二维dp数组，对于每个1，dp[i][j]=dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
    */

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (rows == 1) {
            for (int i = 0; i < cols; i++) {
                if (matrix[0][i] == '1') return 1;
            }
            return 0;
        }

        int res = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                res = 1;
            }
            else dp[0][i] = 0;
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
            else dp[i][0] = 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;
    }

    public static void main(String[] args) {
        char[] char1 = new char[]{'1','1','1','1'};
        char[] char2 = new char[]{'1','1','1','1'};
        char[] char3 = new char[]{'1','1','1','1'};
        char[][] charArr = new char[][]{char1,char2,char3};
        int res = maximalSquare(charArr);
        System.out.println(res);
    }
}
