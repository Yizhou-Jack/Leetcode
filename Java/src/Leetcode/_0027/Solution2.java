package Leetcode._0027;

public class Solution2 {

    /*
    双指针直接覆盖法
     */

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
