package Leetcode._0081;

public class Solution1 {

    public boolean search(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) return false;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            //在判断单调性前，增加一个判断mid和左右边界是否相等（因为有可能出现同样的数字）
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            } else if (nums[mid] == nums[right]) {
                right--;
                continue;
            }
            if (nums[mid] < nums[right]) { //mid右侧单调递增
                if (nums[mid] < target && target <= nums[right]) { //target在单调递增区间内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { //mid左侧单调递增
                if (nums[left] <= target && target <= nums[mid]) { //target在单调递增区间内
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
