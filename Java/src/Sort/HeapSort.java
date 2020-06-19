package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {

    public static void heapSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int i = nums.length-1;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            nums[i] = num;
            i--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,2,7,99,6};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
