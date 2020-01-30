package _0239;

import java.util.Arrays;

public class Solution2 {

    /*
    动态规划法：
    https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
    将数组分为k块。
    从左到右遍历数组，建立数组left（left[j]为块的开头到index j最大的元素）
    从右到左遍历数组，建立数组right（right[j]为块的结尾到index j最大的元素）
    建立好数组之后，考虑下标i到下标j的滑动窗口：
    right[i]为左侧块内的最大元素，left[j]是右侧块内的最大元素，因此滑动窗口内的最大元素为max(right[i], left[j])
    */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(intArr, 3);
        System.out.println(Arrays.toString(res));
    }

}
