package Leetcode._0334;

public class Solution2 {

    /*
    遍历检查数组中数字与m n的大小（m n始终是两个前面最小的值）
    如果遍历到最后都没有return到true，那么就是没有递增三元序列
    */

    public static boolean increasingTriplet(int[] nums) {
        int m = Integer.MAX_VALUE;
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (m >= nums[i]) {
                m = nums[i];
            } else if (n >= nums[i]) {
                n = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,0,0,10,0,0,1000};
        boolean res = increasingTriplet(nums);
        System.out.println(res);
    }
}
