package Leetcode._0234;

import structures.ListNode;

public class Solution1 {

    /*
    通过双指针法找到中间位置的节点，将后半部分反转与前半部分比较
    */

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode leftEnd = endOfLeftPart(head);
        ListNode rightStart = leftEnd.next;
        ListNode reverseRight = reverseListNode(rightStart);

        ListNode l1 = head;
        ListNode l2 = reverseRight;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode endOfLeftPart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
