package _0048;

public class Solution {

    /*
    脑筋急转弯类似的tricky way
    very special problem。
    将大矩阵划分为四个小矩形（n为单数的话中间会多一个小方块不用管），
    对于小矩形中的每个元素，将其按照规律转到相应的位置。
    */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
