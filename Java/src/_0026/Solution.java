package _0026;

public class Solution {

    /*
    双指针法：
    i为慢指针，j为快指针。
    当发现nums[i] != nums[j]，将nums[j]赋值给i+1的位置，就达到了覆盖的目的，空间使用为O(1)
    */

    public static int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        for (; j < nums.length; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,1,1,2,3,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
}
