package Leetcode._0074;

public class Solution1 {

    /*
    二分查找找target值：
    第一列也可以用二分查找来找目标行，不写了
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;

        int i;
        for (i = 0; i < row-1; i++) {
            if (matrix[i+1][0] > target) break;
        }
        int left = 0;
        int right = col - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[i][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return matrix[i][left] == target;
    }
}
