package Leetcode._0059;

public class Solution1 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        int[] direction = new int[]{0,1}; //direction[0]负责控制上下（row），direction[1]负责控制左右（col）

        int row = 0;
        int col = 0;

        int num = 1;
        while (num <= n*n) {
            res[row][col] = num++;
            if (row == up && col == right && direction[1] == 1) {
                direction[0] = 1;
                direction[1] = 0;
                up++;
            } else if (row == down && col == right && direction[0] == 1) {
                direction[0] = 0;
                direction[1] = -1;
                right--;
            } else if (row == down && col == left && direction[1] == -1) {
                direction[0] = -1;
                direction[1] = 0;
                down--;
            } else if (row == up && col == left && direction[0] == -1) {
                direction[0] = 0;
                direction[1] = 1;
                left++;
            }
            row += direction[0];
            col += direction[1];
        }
        return res;
    }

}
