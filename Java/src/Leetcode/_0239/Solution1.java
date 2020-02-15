package Leetcode._0239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution1 {

    /*
    暴力解法优化版：
    记录滑动窗口中max值所在的index，如果max值比新加入的值要大，那么直接把max加到res里面；
    如果max比新加入的值要小，那么重新扫描滑动窗口，更新max index
    */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> resList = new ArrayList<>();

        int len = nums.length;
        if (len == 0) return new int[]{};

        int maxIndex = -1;
        for (int i = 0; i < len-k+1; i++) {
            if (maxIndex >= i+1 && maxIndex <= i+k-2 && nums[maxIndex] > nums[i+k-1]) {
                resList.add(nums[maxIndex]);
            } else {
                int maxNum = Integer.MIN_VALUE;
                for (int j = i; j < i+k; j++) {
                    if (maxNum < nums[j]) {
                        maxNum = nums[j];
                        maxIndex = j;
                    }
                }
                resList.add(nums[maxIndex]);
            }
        }

        return convertIntegers(resList);
    }

    public static int[] convertIntegers(List<Integer> integers){
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(intArr, 3);
        System.out.println(Arrays.toString(res));
    }
}
