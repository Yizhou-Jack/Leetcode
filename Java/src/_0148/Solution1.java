package _0148;

import structures.ListNode;

public class Solution1 {

    /*
    递归归并排序链表：
    先使用双指针法找到一条链表中间的节点（slow节点），找到之后将链表从slow断开。
    对断开的两条链表分别进行排序（递归调用），再对排序后的两条链表进行合并（类似第23题）
    */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head; //终止条件，不可省去

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null; //从中间点断开链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0); //new一个dummy node
        ListNode res = h; //h用于迭代，res用于返回
        //第23题的合并链表方法
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left != null) {
            h.next = left;
        }
        if (right != null) {
            h.next = right;
        }

        return res.next;
    }
}
