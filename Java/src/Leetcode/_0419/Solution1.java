package Leetcode._0419;

import java.util.Arrays;

public class Solution1 {

    public static int countBattleships(char[][] board) {
        int res = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    res++;
                    int m = i;
                    int n = j;
                    while (m-1 >= 0) {
                        if (board[m-1][j] == 'X') {
                            board[m-1][j] = '.';
                        } else break;
                        m--;
                    }
                    while (n-1 >= 0) {
                        if (board[i][n-1] == 'X') {
                            board[i][n-1] = '.';
                        } else break;
                        n--;
                    }
                    m = i;
                    n = j;
                    while (m+1 < row) {
                        if (board[m+1][j] == 'X') {
                            board[m+1][j] = '.';
                        } else break;
                        m++;
                    }
                    while (n+1 < col) {
                        if (board[i][n+1] == 'X') {
                            board[i][n+1] = '.';
                        } else break;
                        n++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] char1 = new char[]{'X','.','X'};
        char[][] charArr = new char[][]{char1};
        int res = countBattleships(charArr);
        for (int i = 0; i < charArr.length; i++) {
            System.out.println(Arrays.toString(charArr[i]));
        }
        System.out.println(res);
    }
}
