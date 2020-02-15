package Leetcode._0138;

public class Solution2 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node l1 = head;
        Node l2 = null;
        //生成所有的节点，并且分别插入到原有节点的后边
        while (l1 != null) {
            l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
        }
        //更新插入节点的 random
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next; //新l1节点的random是原l1节点random的next
            }
            l1 = l1.next.next;
        }

        l1 = head;
        Node l2Head = l1.next;
        //将新旧节点分离开来
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return l2Head;
    }
}
