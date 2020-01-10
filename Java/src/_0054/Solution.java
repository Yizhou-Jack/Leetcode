package _0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    迭代的tricky way。
    up、down、left、right负责记录循环的位置。
    direction这个二维数组负责记录目前的方向。
    当到达边界时，direction变化属性，同时改变循环位置的index。
    */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int up = 0;
        int down = matrix.length-1;
        if (down == -1) { //边界条件
            return res;
        }
        int left = 0;
        int right = matrix[0].length-1;

        int[] direction = new int[]{0,1}; //direction[0]负责控制上下（row），direction[1]负责控制左右（col）

        int row = 0;
        int col = 0;

        int count = (down+1)*(right+1);
        while (count > 0) {
            res.add(matrix[row][col]);
            count--;
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
