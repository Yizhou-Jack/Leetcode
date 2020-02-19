package Leetcode._0025;

import structures.ListNode;

public class Solution1 {

    /*
    自己写的，并不优雅
     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head; //对特殊情况直接return
        ListNode res = null;
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
            if (i == k-1) res = temp;
        }
        if (res == null) return head; //k比链表长度还大，找不到反转后的头结点，直接return

        ListNode prev = new ListNode(0);
        ListNode[] list = new ListNode[k];
        ListNode l = head;
        int i = 0;
        while (true) {
            if (i < k && l != null) { //有三种可能会进入else：要么找完了k个节点；要么还有剩节点；要么链表长度正好被k整除（i==k和l==null）
                list[i] = l;
                l = l.next;
                i++;
            } else {
                if (i < k) break; //如果是还有剩节点的情况，那么直接break，否则继续以下算法（不然在能被整除的情况下list会继续更新导致指向错误）
                for (int j = k-1; j > 0; j--) {
                    list[j].next = list[j-1];
                }
                prev.next = list[k-1];
                list[0].next = l;

                prev = list[0];
                i = 0;
                if (l == null) break; //如果l是null（链表正好被k整除），那么break
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode nodes = ListNode.buildListNode(new int[]{1,2,3,4});
        ListNode res = reverseKGroup(nodes, 6);
        ListNode.printLinkedList(res);
    }
}
