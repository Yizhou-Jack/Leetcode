package _0328;

import structures.ListNode;

public class Solution1 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode startEven = head.next;
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1.next != null && l1.next.next != null) {
            l1.next = l1.next.next;
            l2.next = l2.next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = startEven;
        return head;
    }
}
