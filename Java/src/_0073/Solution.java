package _0073;

import java.util.Arrays;

public class Solution {

    /*
    简单的算法：
    mArr用于记录哪一些rows为0；nArr用于记录哪一些cols为0
    遍历一遍找到哪些rows为0哪些cols为0后将所在位置置为1
    */

    public static void setZeroes(int[][] matrix) {
        int[] mArr = new int[matrix.length];
        int[] nArr = new int[matrix[0].length];
        //遍历一遍，记录下哪些rows为0哪些cols为0，将所在位置置为1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    mArr[i] = 1;
                    nArr[j] = 1;
                }
            }
        }
        //在mArr中找1的位置，将这些rows的内部元素都置为0
        for (int i = 0; i < mArr.length; i++) {
            if (mArr[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //在nArr中找1的位置，将这些cols的内部元素都置为0
        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,0,6};
        matrix[2] = new int[]{7,8,9};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
