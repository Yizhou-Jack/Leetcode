package _0075;

import java.util.Arrays;

public class Solution {

    /*
    荷兰三色旗问题解：三指针法
    只遍历一遍：curr指针记录当前指针遍历到了什么位置，index0指针记录0的位置的最靠右的指针，index2指针记录2的位置的最靠左的指针
    1. 当curr指针扫描到0，index0指针位置数字与curr指针位置数字交换，curr++，index0++
    2. 当curr指针扫描到2，index2指针位置数字与curr指针位置数字交换，index2--
    3. 当curr指针扫描到1，curr++
    */
    public static void sortColors(int[] nums) {
        int index0 = 0;
        int curr = 0;
        int index2 = nums.length - 1;

        int tmp;
        while (curr <= index2) { //当curr>index2时，index2右边的数字都是2，无需继续扫描
            if (nums[curr] == 0) { //交换第index0个和第curr个元素，curr++，index0++
                tmp = nums[index0];
                nums[index0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) { //交换第index2个和第curr个元素，index2--
                tmp = nums[curr];
                nums[curr] = nums[index2];
                nums[index2--] = tmp;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,2,0,1,2,0,1,1,0};
        sortColors(res);
        System.out.println(Arrays.toString(res));
    }
}
