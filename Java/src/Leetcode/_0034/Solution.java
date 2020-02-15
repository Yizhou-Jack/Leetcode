package Leetcode._0034;

import java.util.Arrays;

public class Solution {

    /*
    套用二分查找的模板，使用一次左中位数查找 and 一次右中位数查找
    */

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //左中位数查找
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftRes;
        if (nums[left] == target) { //检查是否存在target
            leftRes = left;
        } else {
            return new int[]{-1, -1};
        }

        left = 0;
        right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; //右中位数查找
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int rightRes;
        if (nums[right] == target) { //检查是否存在target
            rightRes = left;
        } else {
            return new int[]{-1, -1};
        }
        return new int[]{leftRes, rightRes};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,8,8,8,8,10,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
