package Leetcode._0083;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        Set<Integer> set = new HashSet<>();
        ListNode prev = new ListNode(0);
        ListNode l = head;
        prev.next = head;
        while (l != null) {
            if (!set.contains(l.val)) {
                set.add(l.val);
                prev = l;
                l = l.next;
            } else {
                prev.next = l.next;
                l = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1,1,2,2,3});
        ListNode res = deleteDuplicates(head);
        ListNode.printLinkedList(res);
    }
}
