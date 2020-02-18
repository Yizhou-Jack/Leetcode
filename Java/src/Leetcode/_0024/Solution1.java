package Leetcode._0024;

import structures.ListNode;

public class Solution1 {

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.buildListNode(new int[]{1,2,3,4});
        ListNode res = swapPairs(root);
        ListNode.printLinkedList(res);
    }
}
