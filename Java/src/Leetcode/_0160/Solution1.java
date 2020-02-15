package Leetcode._0160;

import structures.ListNode;

public class Solution1 {

    /*
    链表A遍历到最后之后链接至链表B开头；链表B遍历到最后之后链接至链表A开头；
    如此操作，在都转换过一次后，长度差被弥补，如果有相交一定会相交
    */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB) {
            lA = lA == null ? headB : lA.next;
            lB = lB == null ? headA : lB.next;
        }
        return lA;
    }

}
