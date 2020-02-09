package _0016;

import java.util.Arrays;

public class Solution1 {

    /*
    和第15题类似
    */

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int L = i+1;
            int R = len-1;
            while (L < R) {
                int sum = nums[i]+nums[L]+nums[R];
                int minus = sum-target;
                if (Math.abs(minus) < min) {
                    min = Math.abs(minus);
                    res = sum;
                }
                if (minus > 0) {
                    R--;
                } else if (minus < 0) {
                    L++;
                } else return target;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{-3,1,2,4,5,4,3,2};
        int res = threeSumClosest(intArray, 15);
        System.out.println(res);
    }
}
