package Leetcode._0268;

public class Solution1 {

    /*
    数学方法：高斯求和再减去数组中所有的数字
    */

    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

}
