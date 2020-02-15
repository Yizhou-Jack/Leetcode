package Leetcode._0237;

import structures.ListNode;

public class Solution1 {

    /*
    无语。
    直接把要删除的节点改成后面节点的值，然后删除后面节点。
    */

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
