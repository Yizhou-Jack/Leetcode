package _0300;

public class Solution1 {

    /*
    审题错误：
    这个算法计算的是连续上升子序列的长度
    */

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;

        int i = 0;
        int j = 1;
        int maxLen = -1;
        while (j < len) {
            while (j < len && nums[j] > nums[j-1]) j++;
            maxLen = Math.max(maxLen, j-i);
            j++;
            i = j-1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
