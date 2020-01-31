package _0283;

import java.util.Arrays;

public class Solution1 {

    /*
    遍历数组把非零元素（假设有k个）按顺序存入数组的0至k-1位置上；
    把原数组剩余未新赋值部分(k到n-1位置上)全设置为0；
    */

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,3,4,6,0,0,5,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
