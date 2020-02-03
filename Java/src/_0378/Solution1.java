package _0378;

public class Solution1 {

    /*
    矩阵中的二分查找方法
    */

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        //二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        //以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                //第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                //第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

}
