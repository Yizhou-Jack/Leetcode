import structures.ListNode;

import java.util.Arrays;

public class Test {

    public static int searchInsertRightMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; //找右中位数
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int j = 3;
        for (int i = 0; i < 7 && i != j; i++) {
            System.out.println(i);
        }
    }
}
