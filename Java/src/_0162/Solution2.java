package _0162;

public class Solution2 {

    /*
    二分查找模板
    */

    public static int findPeakElement(int[] nums) {
        if (nums == null) return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid =  left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { //峰值在右边
                left = mid + 1;
            } else { //峰值在左边
                right = mid;
            }
        }

        return left;
    }
}
