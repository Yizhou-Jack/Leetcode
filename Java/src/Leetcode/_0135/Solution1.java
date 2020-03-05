package Leetcode._0135;

public class Solution1 {

    /*
    动态规划解法：
    相邻的孩子中，评分高并且在右边的孩子要比左边多一个糖果（第一次扫描）；
    相邻的孩子中，评分高并且在左边的孩子要比右边多一个谈过（第二次扫描）
     */

    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] nums = new int[len];
        for (int i = 0; i < len; i++) nums[i] = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) nums[i] = nums[i-1]+1;
        }
        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) nums[i] = Math.max(nums[i], nums[i+1]+1);
        }

        int res = 0;
        for (int i = 0; i < len; i++) res += nums[i];
        return res;
    }
}
