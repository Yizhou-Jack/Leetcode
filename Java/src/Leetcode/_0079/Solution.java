package Leetcode._0079;

public class Solution {

    /*
    回溯算法的模板做了一些改动：
    本来是使用public boolean res作为全局变量，如果找到了一条路景就会修改res为true；
    但是这样会造成我们多次寻找路径，而不是有路径时就直接返回结束寻找，因此在某些极端情况会造成超时。
    所以将find函数（也就是backtrack函数）改为boolean返回值，找到路径就直接返回true，不继续迭代。
    */

    public boolean exist(char[][] board, String word) {
        if(board.length < 1 || word.length() < 1) {
            return false;
        }
        char c = word.charAt(0);
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == c) {
                    char tmp = c;
                    board[m][n] = '#'; //用#填充已经寻找过的路径，不走回头路
                    if (find(1, word, board, m, n)) return true;
                    board[m][n] = tmp; //将数字填充回去
                }
            }
        }
        return false;
    }

    public boolean find(int i, String word, char[][] board, int m, int n) {
        if (i == word.length()) {
            return true;
        } else {
            //向右
            if (n+1 < board[0].length && word.charAt(i) == board[m][n+1]) {
                char tmp = board[m][n+1];
                board[m][n+1] = '#';
                if (find(i+1, word, board, m, n+1)) return true;
                board[m][n+1] = tmp;
            }
            //向左
            if (n-1 >= 0 && word.charAt(i) == board[m][n-1]) {
                char tmp = board[m][n-1];
                board[m][n-1] = '#';
                if (find(i+1, word, board, m, n-1)) return true;
                board[m][n-1] = tmp;
            }
            //向上
            if (m+1 < board.length && word.charAt(i) == board[m+1][n]) {
                char tmp = board[m+1][n];
                board[m+1][n] = '#';
                if (find(i+1, word, board, m+1, n)) return true;
                board[m+1][n] = tmp;
            }
            //向下
            if (m-1 >= 0 && word.charAt(i) == board[m-1][n]) {
                char tmp = board[m-1][n];
                board[m-1][n] = '#';
                if (find(i+1, word, board, m-1, n)) return true;
                board[m-1][n] = tmp;
            }
            return false;
        }
    }
}
