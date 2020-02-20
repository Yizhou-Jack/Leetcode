package Leetcode._0153;

public class Solution1 {

    public static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        for (int i = 0; i < len-1; i++) {
            if (nums[i] > nums[i+1]) return nums[i+1];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int res = findMin(new int[]{1,2,3});
        System.out.println(res);
    }
}
