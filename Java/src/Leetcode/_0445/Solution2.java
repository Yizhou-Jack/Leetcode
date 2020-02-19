package Leetcode._0445;

import structures.ListNode;

import java.util.Stack;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode node1 = l1;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        ListNode head = null;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int value = 0;
            if (!stack1.isEmpty()) value += stack1.pop();
            if (!stack2.isEmpty()) value += stack2.pop();
            value += flag;
            ListNode node = new ListNode(value%10);
            flag = value/10;
            node.next = head;
            head = node;
        }
        return head;
    }
}
