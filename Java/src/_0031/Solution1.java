package _0031;

import java.util.Arrays;

public class Solution1 {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;

        int i = len-1;
        int tmp;
        while (len > 0) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            }
            if (nums[i-1] >= nums[i]) {
                i--;
            } else {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1]) {
                        tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
