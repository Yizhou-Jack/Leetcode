package _0238;

import java.util.Arrays;

public class Solution1 {

    /*
    首先构造res，res[i]为index左边所有数字的乘积；
    再利用right更新res，right为index右边所有数字的乘积，与res[i]相乘则是左右两边数字的乘积
    */

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }

        int right = 1;
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
