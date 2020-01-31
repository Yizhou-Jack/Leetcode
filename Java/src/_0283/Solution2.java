package _0283;

import java.util.Arrays;

public class Solution2 {

    /*
    定义两个指针变量，i用来往前探索，j用来保持 <=j 的数非0
    */

    public static void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,3,4,6,0,0,5,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
