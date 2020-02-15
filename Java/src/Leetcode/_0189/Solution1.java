package Leetcode._0189;

public class Solution1 {

    /*
    一次移动一格，移动k次
    */

    public void rotate(int[] nums, int k) {
        int temp;
        int previous;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            previous = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

}
