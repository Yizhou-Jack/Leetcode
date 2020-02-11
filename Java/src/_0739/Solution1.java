package _0739;

import java.util.Arrays;

public class Solution1 {

    /*
    N^2解法
    */

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(intArr);
        System.out.println(Arrays.toString(res));
    }
}
