package Leetcode._0023;

import structures.ListNode;

public class Solution {

    /*
    将k lists持续merge two lists，直到合并为一个list（使用0021中的merge two lists方法）
    */

    public static ListNode mergeKLists(ListNode[] lists){
        int len = lists.length;
        if (len == 0) return null;
        //将n个链表以中间为对称持续合并直到len==1
        while (len > 1){
            for (int i = 0; i < len/2; i++){
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists[0];
    }

    //合并两个链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
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
        }
        else{
            prev.next = l1;
        }
        return dummy.next; //返回哑变量的下一个节点（即为头结点）
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,3,4,5});
        ListNode l2 = ListNode.buildListNode(new int[]{1,2,3,4,5});
        ListNode l3 = ListNode.buildListNode(new int[]{2,3,4,5,6});
        ListNode l4 = ListNode.buildListNode(new int[]{4,5,6,7});
        ListNode[] listNodes = new ListNode[]{l1, l2, l3, l4};
        ListNode.printLinkedList(l1);
        System.out.println("l1:---");
        ListNode.printLinkedList(l2);
        System.out.println("l2:---");
        ListNode.printLinkedList(l3);
        System.out.println("l3:---");
        ListNode.printLinkedList(l4);
        System.out.println("l4:---");
        ListNode res = mergeKLists(listNodes);
        ListNode.printLinkedList(res);
    }

}
