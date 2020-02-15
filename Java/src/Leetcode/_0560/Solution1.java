package Leetcode._0560;

public class Solution1 {

    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == k ? 1 : 0;
        int res = 0;

        int[] dp = new int[len];
        dp[0] = nums[0];
        if (dp[0] == k) res++;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1] + nums[i];
            if (dp[i] == k) res++;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                dp[j] = dp[j] - nums[i];
                if (dp[j] == k) res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int res = subarraySum(nums, 2);
        System.out.println(res);
    }
}
