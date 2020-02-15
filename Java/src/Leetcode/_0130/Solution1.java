package Leetcode._0130;

public class Solution1 {

    /*
    DFS思路解法：
    从边界的0开始做dfs，将碰到的0都标记出来。最后遍历节点，把没有标记过的0都改成X。
    */

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            //最上边一行的所有O做DFS
            if (board[0][i] == 'O') dfs(0, i, board, visited);
            //最下边一行的所有O做DFS
            if (board[rows - 1][i] == 'O') dfs(rows - 1, i, board, visited);
        }
        for (int i = 0; i < rows; i++) {
            //最左边一列的所有O做DFS
            if (board[i][0] == 'O') dfs(i, 0, board, visited);
            //最右边一列的所有O做DFS
            if (board[i][cols - 1] == 'O') dfs(i, cols - 1, board, visited);
        }

        //把所有没有标记过的O改为X
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    public void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
            dfs(i + 1, j, board, visited);
            dfs(i, j + 1, board, visited);
            dfs(i, j - 1, board, visited);
            dfs(i - 1, j, board, visited);
        }
    }
}
