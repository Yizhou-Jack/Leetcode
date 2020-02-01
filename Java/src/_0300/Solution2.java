package _0300;

import java.util.Arrays;

public class Solution2 {

    /*
    动态规划法：
    维护dp，两个for循环扫描确定每个dp[i]的值，最后返回dp数组中的最大值
    */

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;

        int[] dp = new int[len];
        dp[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i; j < len; j++) {
                if (nums[j] > nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
