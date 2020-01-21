package _0152;

public class Solution1 {

    /*
    动态规划法：
    遍历数组时计算当前最大值，不断更新；
    令max为当前最大值，则当前最大值为max(max*nums[i], nums[i])；
    由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值min；
    当负数出现时则imax与imin进行交换再进行下一步计算
    */

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }
}
