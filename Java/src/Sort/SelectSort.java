package Sort;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,2,7,99,6};
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
