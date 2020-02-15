package Leetcode._0033;

public class Solution {

    /*
    二分查找的变形：套用CommonTools里的二分查找模板。
    找到mid的位置之后，有两层if判断：
    首先判断是左边还是右边的数组有序，其次判断target在不在有序数组中；然后根据四种判断的结果收缩left or right的值。
    */

    public int search(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; //不使用(left+right)/2的原因是防止left+right造成整型溢出
            if (nums[mid] < nums[right]) { //比较mid的数字和right的数字，right比mid大则说明右边的数组是有序的
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid; //如果target在右边的有序数组中，那么将left收缩至mid处
                } else {
                    right = mid - 1; //如果target不在右边，那么将right收缩至mid-1处
                }
            } else { //此时说明左边的数组是有序的
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1; //如果target在左边的有序数组中，那么将right收缩至mid-1处
                } else {
                    left = mid; //如果target不在左边，那么将left收缩至mid处
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
