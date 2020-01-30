package _0240;

public class Solution2 {

    /*
    从左下角开始迭代指针，比较matrix[row][col]和target的大小，
    大了则row--，小了则col++
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        //从左下角开始迭代指针
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

}
