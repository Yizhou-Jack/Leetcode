package Leetcode._0021;

import structures.ListNode;

public class Solution {

    /*
    维护prev指针，如果l1此时的值比l2要小，那么把l1的值接到prev的后面，然后将l1指针向后移动一个；
                否则把l2的值接到prev的后面，然后将l2指针向后移动一个.
    如果l1或者l2有个为null，那么可以直接将prev.next指向不为null的链表
    */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //构建哑节点
        ListNode prev = dummy; //循环用
        //循环中比较l1.val与l2.val的大小，不断地将prev的next节点链接上去
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //跳出while循环时l1和l2必定有个已然指到末尾变成了null，那么可以直接将prev.next指向不为null的链表
        if (l1 == null){
            prev.next = l2;
        } else{
            prev.next = l1;
        }

        return dummy.next; //返回哑变量的下一个节点（即为头结点）
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,3,4,5});
        ListNode l2 = ListNode.buildListNode(new int[]{1,2,3,4,5});
        ListNode.printLinkedList(l1);
        System.out.println("l1:---");
        ListNode.printLinkedList(l2);
        System.out.println("l2:---");
        ListNode res = mergeTwoLists(l1, l2);
        ListNode.printLinkedList(res);
    }
}
