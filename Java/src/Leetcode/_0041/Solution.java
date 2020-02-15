package Leetcode._0041;

public class Solution {

    /*
    非常tricky的方法
    */

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        int contains = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) { //检查是否存在1
            return 1;
        }
        if (len == 1) { //检查是否是[1]
            return 2;
        }
        //用1替换负数、0、大于n的数，在转换以后，nums只会包含正数
        for (int i = 0; i < len; i++) {
            if ((nums[i] <= 0) || (nums[i] > len)) {
                nums[i] = 1;
            }
        }
        //使用索引和数字符号作为检查器：
        //例如，如果nums[1]是负数表示在数组中出现了数字1
        //如果nums[2]是正数，那么表示数字2没有出现
        for (int i = 0; i < len; i++) {
            int a = Math.abs(nums[i]); //在第i位上的数字的绝对值
            //如果发现了一个数字a，那么就改变第a个元素的符号
            if (a == len) {
                nums[0] = -Math.abs(nums[0]); //特殊的a==len，那么改变nums[0]来检查
            } else {
                nums[a] = -Math.abs(nums[a]); //重复元素就算重复也是负数
            }
        }

        //现在第一个正数的下标就是第一个缺失的数
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        //检查nums[0]判断是不是a==len缺失
        if (nums[0] > 0) {
            return len;
        }
        //如果都不是以上情况，那么就是一个从1开始++的数列，要返回len+1
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,-9,5,2,1,7,19,20};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
