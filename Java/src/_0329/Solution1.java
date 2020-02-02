package _0329;

public class Solution1 {

    /*
    记忆化的DFS算法：
    原先需要遍历每个节点进行dfs，现在用记忆化的方法记录下每个节点的当前最大递增序列数，避免重复dfs
    */

    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
    }

}
