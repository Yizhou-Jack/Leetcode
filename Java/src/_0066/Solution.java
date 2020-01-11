package _0066;

import java.util.Arrays;

public class Solution {

    /*
    数学方法，很简单
    */

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits; //没有找到进位直接return
        }
        digits = new int[digits.length + 1]; //能够到这里说明是[9,9,9]或者[9,9,9,9]类似的情况
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9,9};
        int[] res = plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

}
