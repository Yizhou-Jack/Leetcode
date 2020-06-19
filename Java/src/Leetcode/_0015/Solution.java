package Leetcode._0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /*
    双指针方法：
    首先排序输入的数列nums。
    从第一位数字开始，将两个游标设置在右边的第一个数字与最后一位数字上，
    如果三位数字加起来小于0，则左边的游标向右边移动一格（令总和增大）；如果三位数字加起来大于0，则右边的游标向左边移动一格（令总和减小）。
    由于不能出现重复的数组，那么还需要检查重复性：
    1. nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
    2. 当sum == 0时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
    3. 当sum == 0时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
    */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return res;
        Arrays.sort(nums); //排序
        for (int i = 0; i < len ; i++){
            //计算的是nums[i]和nums[i]之后的两个数字之和
            if (nums[i] > 0) break; //如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i-1]) continue; //去重
            int L = i+1;
            int R = len-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; //去重
                    while (L<R && nums[R] == nums[R-1]) R--; //去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{-3,1,2,4,5,4,3,2};
        List<List<Integer>> res = threeSum(intArray);
        System.out.println(res);
    }
}
