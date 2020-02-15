package Leetcode._0289;

public class Solution1 {

    /*
    遍历两遍矩阵：第一遍标记细胞转换的状态（0 to 0 // 0 to 1 // 1 to 0 // 1 to 1）
                第二遍将1 to 1的细胞和0 to 1的细胞状态更新为1；将1 to 0的细胞和0 to 0的细胞状态更新为0
    */

    public void gameOfLife(int[][] board) {
        //第一遍遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = checkLoc(board, i, j);
            }
        }
        //第二遍遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    public int checkLoc(int[][] board, int i, int j){
        int count = 0;
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for (int x = top; x <= bottom; x++) {
            for (int y = left; y <= right; y++) {
                if (board[x][y] == 1 || board[x][y] == -1) count++;
            }
        }
        if (board[i][j] == 1) {
            count--;
            return count == 2 || count == 3 ? 1 : -1; //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
                                                      //如果活细胞周围八个位置的活细胞数少于两个or超过三个，则该位置活细胞死亡
        } else {
            return count == 3 ? -2 : 0; //如果死细胞周围正好有三个活细胞，则该位置死细胞复活
        }
    }
}
