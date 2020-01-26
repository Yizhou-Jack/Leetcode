package _0206;

import structures.ListNode;

public class Solution1 {

    /*
    迭代法：
    在遍历列表时，将当前节点的next指针指向前一个元素
    */

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{1,2,3,4,5};
        ListNode node = ListNode.buildListNode(intArr);
        ListNode res = reverseList(node);
        ListNode.printLinkedList(res);
    }
}
