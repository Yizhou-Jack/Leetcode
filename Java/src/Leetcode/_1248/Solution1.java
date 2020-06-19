package Leetcode._1248;

import java.util.Arrays;

public class Solution1 {

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start < nums.length; start++) {
                int end = start+len-1;
                if (end >= nums.length) break;
                if (len == 1) {
                    dp[start][end] = nums[start]%2 == 0 ? 0 : 1;
                    continue;
                } else if (len == 2) {
                    int a = nums[start]%2 == 0 ? 0 : 1;
                    int b = nums[end]%2 == 0 ? 0 : 1;
                    dp[start][end] = a+b;
                    continue;
                } else {
                    int a = nums[start]%2 == 0 ? 0 : 1;
                    int b = nums[end]%2 == 0 ? 0 : 1;
                    dp[start][end] = a+b+dp[start+1][end-1];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (dp[i][j] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        int res = numberOfSubarrays(nums, 2);
        System.out.println(res);
    }

}
