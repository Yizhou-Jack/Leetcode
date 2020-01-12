package tools;

import java.util.Arrays;

public class CreateStructure {

    /*
    创建int[][]
    */
    public void CreateIntArrArr() {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
