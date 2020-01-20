package _0141;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode l = head;
        while (l != null) {
            if (!set.contains(l)) {
                set.add(l);
                l = l.next;
            } else {
                return true;
            }
        }
        return false;
    }

}
