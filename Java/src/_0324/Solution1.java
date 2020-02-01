package _0324;

import java.util.Arrays;

public class Solution1 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] smallArr = new int[len%2 == 0 ? len/2 : len/2+1];
        int[] bigArr = new int[len/2];
        //复制
        System.arraycopy(nums,0, smallArr,0, smallArr.length);
        System.arraycopy(nums, smallArr.length, bigArr,0,len/2);
        //穿插
        int i = 0;
        for (; i < len/2; i++) {
            nums[2*i] = smallArr[smallArr.length-1-i];
            nums[2*i+1] = bigArr[len/2-1-i];
        }
        if (len%2 != 0) nums[2*i] = smallArr[smallArr.length-1-i];
    }

}
