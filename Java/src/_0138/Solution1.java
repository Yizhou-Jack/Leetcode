package _0138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution1 {

    /*
    遍历两遍链表：
    一遍生成所有的节点保存在hashmap中，第二遍遍历原链表，将其next和random复制给新链表
    */

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node h = head;
        //生成所有节点
        while (h != null) {
            Node t = new Node(h.val);
            map.put(h, t);
            h = h.next;
        }
        h = head;
        //更新next和random
        while (h != null) {
            if (h.next != null) {
                map.get(h).next = map.get(h.next);
            }
            if (h.random != null) {
                map.get(h).random = map.get(h.random);
            }
            h = h.next;
        }
        return map.get(head);
    }
}
