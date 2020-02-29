package Leetcode._0167;

import java.util.Arrays;

public class Solution1 {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int len = numbers.length;
        int m = 0;
        int n = len-1;
        while (n > m) {
            int sum = numbers[m] + numbers[n];
            if (target == sum) {
                res[0] = m+1;
                res[1] = n+1;
                break;
            }
            if (target < sum) n--;
            if (target > sum) m++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,7,19};
        int target = 12;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
