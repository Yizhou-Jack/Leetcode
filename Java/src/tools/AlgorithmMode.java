package tools;

public class AlgorithmMode {

    /*
    二分查找（找左中位数）
    */
    public static int searchInsertLeftMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            //mid = (left + right) >> 1
            int mid = left + (right - left) / 2; //找左中位数
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /*
    二分查找（找右中位数）
    */
    public static int searchInsertRightMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            //mid = (left + right + 1) >> 1
            int mid = left + (right + 1 - left) / 2; //找右中位数
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
