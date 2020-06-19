package Leetcode._0027;

import java.util.Arrays;

public class Solution1 {

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] == val) break;
            else i++;
        }
        if (i == nums.length) return i;

        int res = 0;
        while (j < nums.length) {
            if (nums[j] < val) {
                j++;
                res++;
            } else if (nums[j] == val) j++;
            else break;
        }

        while (j < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
            res++;
        }

        return res;
    }

}
