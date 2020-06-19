package Leetcode._1248;

public class Solution2 {

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int feed = 0;
        int res = 0;
        int[] arr = new int[len+2];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                feed++;
                arr[feed] = i;
            }
        }

        arr[0] = -1;
        arr[feed+1] = len;
        for (int i = 1; i+k < feed+2; i++) {
            res += (arr[i]-arr[i-1])*(arr[i+k]-arr[i+k-1]);
        }

        return res;
    }

}
