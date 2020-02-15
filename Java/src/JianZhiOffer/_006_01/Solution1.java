package JianZhiOffer._006_01;

import structures.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution1 {

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        ListNode l = head;
        while (l != null) {
            num++;
            stack.push(l.val);
            l = l.next;
        }

        int[] res = new int[num];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1,3,2});
        int[] res = reversePrint(head);
        System.out.println(Arrays.toString(res));
    }
}
