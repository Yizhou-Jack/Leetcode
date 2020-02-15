package Leetcode._0141;

import structures.ListNode;

public class Solution2 {

    /*
    双指针法：
    慢指针一次移动一格距离，快指针一次移动两格距离。
    如果慢指针等于快指针，那么存在环。
    */

    public boolean hasCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            if (l2.next != null) {
                l2 = l2.next.next;
            } else {
                return false;
            }
            if (l1 == l2) return true;
        }
        return false;
    }
}
