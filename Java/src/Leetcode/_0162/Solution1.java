package Leetcode._0162;

public class Solution1 {

    /*
    前进一个或者两个的迭代查找方法
    */

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len < 2 || nums[0] > nums[1]) return 0;
        int i = 1;
        while (i < len-1) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
            if (nums[i] > nums[i+1]) {
                i++;
            }
            i++;
            if (i == len-1 && nums[i-1] < nums[i]) return i;
        }
        return i;
    }
}
