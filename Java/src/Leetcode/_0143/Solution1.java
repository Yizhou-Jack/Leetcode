package Leetcode._0143;

import structures.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {

    public static void reorderList(ListNode head) {
        int n = 0;
        ListNode l1 = head;
        while (l1 != null) {
            l1 = l1.next;
            n++;
        }
        l1 = head;
        if (n < 3) return;

        ListNode middle = null;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i < n/2) {
                stack.push(l1);
            } else if (n%2 == 1 && i == n/2) {
                middle = l1;
            } else if (n%2 == 1 && i > n/2) {
                queue.add(l1);
            } else if (n%2 == 0 && i >= n/2) {
                queue.add(l1);
            }
            l1 = l1.next;
        }
        //System.out.println(middle.val);

        ListNode prevLarger = queue.poll();
        ListNode prevSmaller = stack.pop();
        prevLarger.next = null;
        if (n%2 == 1) {
            prevSmaller.next = prevLarger;
            prevLarger.next = middle;
        }
        while (!stack.isEmpty() && !queue.isEmpty()) {
            ListNode larger = queue.poll();
            ListNode smaller = stack.pop();
            smaller.next = larger;
            larger.next = prevSmaller;
            prevSmaller = smaller;
        }
        prevLarger.next = middle;
        if (middle != null) middle.next = null;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1,2,3,4,5,6,7,8});
        reorderList(node);
        ListNode.printLinkedList(node);
    }
}
