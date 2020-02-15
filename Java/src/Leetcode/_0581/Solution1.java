package Leetcode._0581;

import java.util.Arrays;

public class Solution1 {

    public static int findUnsortedSubarray(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);

        int min = 0;
        int max = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag == 0 && nums[i] != nums2[i]) {
                min = i;
                flag = 1;
            }
            if (nums[i] != nums2[i]) max = i;
        }

        return max == min ? 0 : max-min+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        int res = findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
