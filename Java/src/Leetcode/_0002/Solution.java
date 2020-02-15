package Leetcode._0002;

import structures.ListNode;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, node = null;
        int carry = 0, sum = 0;
        while (!(l1 == null && l2 == null)) {
            // both not null
            if (l1 != null && l2 != null) {
                sum = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10; //carry 进位
                l1 = l1.next;
                l2 = l2.next;
            }
            // l1==null
            else if (l1 == null && l2 != null) {
                sum = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            // l2==null
            else if (l1 != null && l2 == null) {
                sum = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            // both null
            else {
                // break out of the loop
            }
            if (head == null) {
                head = new ListNode(sum);
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
        }
        if (carry > 0) { //最后一个进位
            while (carry > 0) {
                int curr = carry % 10;
                node.next = new ListNode(curr);
                node = node.next;
                carry = carry / 10;
            }
        }
        return head;
    }

    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    */

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,4,4,3});
        ListNode l2 = ListNode.buildListNode(new int[]{5,6,6,4});
        ListNode targetNode = addTwoNumbers(l1, l2);
        ListNode.printLinkedList(targetNode);
    }
}
