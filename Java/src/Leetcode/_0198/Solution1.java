package Leetcode._0198;

public class Solution1 {

    /*
    动态规划法：找状态转移方程
    可以找到：
    f(0) = A1
    f(1) = max(A1, A2)
    f(2) = max(f(0)+A3, f(1))
    ......
    */

    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = tmp;
        }
        return currMax;
    }

}
