package Leetcode._0215;

import java.util.Arrays;

public class Solution1 {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{3,2,3,1,2,4,5,5,6};
        int res = findKthLargest(intArr, 4);
        System.out.println(res);
    }
}
