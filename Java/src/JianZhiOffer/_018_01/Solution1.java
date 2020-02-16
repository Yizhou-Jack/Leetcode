package JianZhiOffer._018_01;

import structures.ListNode;

public class Solution1 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = prev.next.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}
