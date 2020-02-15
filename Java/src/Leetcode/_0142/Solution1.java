package Leetcode._0142;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    /*
    用set来存经历过的节点
    */

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode l = head;
        while (l != null) {
            if (set.contains(l)) return l;
            set.add(l);
            l = l.next;
        }
        return null;
    }
}
