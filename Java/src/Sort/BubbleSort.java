package Sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,2,7,99,6};
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
