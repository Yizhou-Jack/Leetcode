package Leetcode._0217;

import java.util.Arrays;

public class Solution1 {

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return false;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{3,2,3,1,2,4,5,5,6};
        boolean res = containsDuplicate(intArr);
        System.out.println(res);
    }
}
