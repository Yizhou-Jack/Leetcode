package Sort;

import java.util.Arrays;
import java.util.Stack;

public class InsertSort {

    public static void insertSort(int[] nums) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Stack<Integer> stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                if (stack1.peek() > nums[i]) {
                    stack2.push(stack1.pop());
                } else break;
            }
            stack1.push(nums[i]);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        int i = nums.length-1;
        while (!stack1.isEmpty()) {
            nums[i] = stack1.pop();
            i--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,7,45,3,2,7,99,6};
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
