package _0033;

public class Solution {

    /*
    二分查找的变形
    */

    public int search(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2;
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
