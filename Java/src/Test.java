import structures.ListNode;

import java.util.Arrays;

public class Test {

    public static int searchInsertRightMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; //找右中位数
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[5];
        ListNode nodes = ListNode.buildListNode(new int[]{1,2,3,4,5});
        ListNode res = nodes;
        ListNode res2 = nodes;
        for (int i = 0; i < 5; i++) {
            list[i] = nodes;
            nodes = nodes.next;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list[i]);
            System.out.println(res);
            res = res.next;
            System.out.println(" ");
        }
        for (int i = 4; i > 0; i--) {
            list[i].next = list[i-1];
        }
        list[0].next = null;
        for (int i = 0; i < 5; i++) {
            System.out.println(list[i].next);
        }
        ListNode.printLinkedList(res2);
    }
}
