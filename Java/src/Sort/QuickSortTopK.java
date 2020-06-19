package Sort;

import java.util.Arrays;
import java.util.LinkedList;

public class QuickSortTopK {

    public static LinkedList<Integer> res = new LinkedList<>();

    public static void quickSortTopK(int[] nums, int left, int right, int k) {
        int i = left;
        int j = right;
        if (i >= j) {
            for (int l = nums.length-k; l < nums.length; l++) {
                res.add(nums[l]);
            }
            return;
        }
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
        if (nums.length-i > k) {
            quickSortTopK(nums, i+1, right, k);
        } else if (nums.length-i < k) {
            quickSortTopK(nums, left, i-1, k);
        } else {
            for (int l = i; l < nums.length; l++) {
                res.add(nums[l]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,4,9,99,18};
        System.out.println(Arrays.toString(nums));
        int k = 5;
        quickSortTopK(nums, 0, nums.length-1, k);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < k; i++) {
            System.out.println(res.get(i));
        }
    }
}
