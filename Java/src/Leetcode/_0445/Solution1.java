package Leetcode._0445;

import structures.ListNode;

public class Solution1 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode L1 = reverse(l1);
        ListNode L2 = reverse(l2);

        ListNode l = new ListNode((L1.val+L2.val)%10);
        ListNode head = l;
        int add = (L1.val+L2.val) >= 10 ? 1 : 0;
        L1 = L1.next;
        L2 = L2.next;
        while (L1 != null || L2 != null || add == 1) {
            int L1val = L1 == null ? 0 : L1.val;
            int L2val = L2 == null ? 0 : L2.val;
            ListNode node = new ListNode((L1val+L2val+add)%10);
            add = (L1val+L2val+add) >= 10 ? 1 : 0;
            l.next = node;
            l = l.next;
            if (L1 != null) L1 = L1.next;
            if (L2 != null) L2 = L2.next;
        }
        return reverse(head);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{5});
        ListNode l2 = ListNode.buildListNode(new int[]{5});
        ListNode res = addTwoNumbers(l1,l2);
        ListNode.printLinkedList(res);
    }
}
