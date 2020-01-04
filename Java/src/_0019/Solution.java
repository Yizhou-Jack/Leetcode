package _0019;

import structures.ListNode;

public class Solution {

    /*
    双指针法：（只需遍历一次链表）
    首先需要设置一个哑节点（用来避免极端情况的bug，比如只有一个头结点），
    first指针向前移动n个节点后，first和second节点同时移动，那么first和second节点会一直保持n个节点的距离差。
    当first指针移动到下一个为节点为null时，将second.next == second.next.next，就删去了second.next节点。
    */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //移动first指针向前n个位置
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //同时移动first和second指针向前直到first.next为null
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next; //删去倒数第n个节点
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,4,5,3});
        ListNode.printLinkedList(l1);
        ListNode l2 = removeNthFromEnd(l1, 2);
        ListNode.printLinkedList(l2);
    }
}
