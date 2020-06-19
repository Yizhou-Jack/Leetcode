package Sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        if (i >= j) return;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,2,7,99,6};
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
