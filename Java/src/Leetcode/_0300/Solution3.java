package Leetcode._0300;

public class Solution3 {

    /*
    动态规划+二分查找：
    tails[k]的值代表长度为k+1子序列的尾部元素值。
    res为tails当前长度，代表直到当前的最长上升子序列长度。设j∈[0,res)，考虑每轮遍历nums[k]时，通过二分法遍历[0,res)列表区间，
    找出nums[k]的大小分界点，会有两种情况：
    1. 区间中存在tails[i] > nums[k]：将第一个满足tails[i] > nums[k]执行tails[i]=nums[k]
    2. 区间中不存在tails[i] > nums[k]：意味着nums[k]可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面，
       新子序列长度为res+1
    最后返回res的长度
    */

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
