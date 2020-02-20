package Leetcode._0153;

public class Solution2 {

    /*
    二分查找方法
     */

    public static int findMin(int[] nums) {
        int len = nums.length;

        if (len == 1) return nums[0];

        int left = 0;
        int right = len - 1;
        if (nums[right] > nums[0]) return nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid-1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = findMin(new int[]{1,2,3});
        System.out.println(res);
    }
}
