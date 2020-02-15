package Leetcode._0061;

import structures.ListNode;

public class Solution1 {

    /*
    先找出链表的长度，再将末尾连接到开头，再找到中段的位置将其断开
    */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode dummy = head;
        int len = 1;
        // 从头到尾遍历链表并记录链表长度len
        while (head.next != null) {
            len++;
            head = head.next;
        }

        //计算需要移动多少位
        if (k > len) {
            len = len - k % len - 1;
        } else if (k == len) {
            return dummy;
        } else {
            len = len - k - 1;
        }

        //尾部指向头部
        head.next = dummy;
        head = dummy;
        //通过len寻找新链表的尾部
        for (int i = 0; i < len; i++) {
            head = head.next;
        }

        //新链表尾部的next就是head
        dummy = head.next;
        //断开环形链表，使其形成单向链表
        head.next = null;
        //返回新链表的头部
        return dummy;
    }

    public static void main(String[] args) {
        ListNode nodes = ListNode.buildListNode(new int[]{1,2});
        ListNode res = rotateRight(nodes, 2);
        ListNode.printLinkedList(res);
    }
}
