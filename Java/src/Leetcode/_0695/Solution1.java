package Leetcode._0695;

public class Solution1 {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid)+1); //加上自己本身
                }
            }
        }
        return res;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return -1;
        }
        grid[i][j] = 0;
        int a = dfs(i + 1, j, grid)+1; //向右找的岛屿数量
        int b = dfs(i, j + 1, grid)+1; //向上找的岛屿数量
        int c = dfs(i, j - 1, grid)+1; //向下找的岛屿数量
        int d = dfs(i - 1, j, grid)+1; //向左找的岛屿数量
        return a+b+c+d;
    }
}
