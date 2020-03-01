package Leetcode._0174;

public class Solution2 {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row + 1][col + 1];
        //终点所需要的值
        dp[row - 1][col - 1] = dungeon[row - 1][col - 1] > 0 ? 1 : -dungeon[row - 1][col - 1] + 1;
        //扩充的边界更新为最大值
        for (int i = 0; i <= col; i++) {
            dp[row][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= row; i++) {
            dp[i][col] = Integer.MAX_VALUE;
        }

        //逆过来更新
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) continue;
                //选择向右走还是向下走，一行行的更新
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][0];
    }
}
