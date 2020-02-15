package Leetcode._0036;

public class Solution {

    /*
    只迭代一次数组就可以完成：
    维护三个int[9][9]数组，代表数字在row/col/box中出现的次数（初始值都为0）
    */

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < 9; i++) { //new int[9]使得初始值都为0
            rows[i] = new int[9];
            columns[i] = new int[9];
            boxes[i] = new int[9];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num-'0'; //char转换为int
                    int boxIndex = (i / 3 ) * 3 + j / 3;
                    rows[i][n-1] = rows[i][n-1] + 1; //第i row中index为n-1的数字（即为数字n）个数增加1
                    columns[j][n-1] = columns[j][n-1] + 1; //第j col中index为n-1的数字（即为数字n）个数增加1
                    boxes[boxIndex][n-1] = boxes[boxIndex][n-1] + 1; //第boxIndex box中index为n-1的数字（即为数字n）个数增加1
                    //如果某个数字大于1，那么就已经出现了两次
                    if (rows[i][n-1] > 1 || columns[j][n-1] > 1 || boxes[boxIndex][n-1] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][];
        board[0] = "53..7....".toCharArray();
        board[1] = "6..195...".toCharArray();
        board[2] = ".98....6.".toCharArray();
        board[3] = "8...6...3".toCharArray();
        board[4] = "4..8.3..1".toCharArray();
        board[5] = "7...2...6".toCharArray();
        board[6] = ".6....28.".toCharArray();
        board[7] = "...419..5".toCharArray();
        board[8] = "....8..79".toCharArray();
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }
}
