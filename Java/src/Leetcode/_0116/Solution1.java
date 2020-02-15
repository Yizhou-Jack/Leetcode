package Leetcode._0116;

import structures.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

    /*
    迭代解法：
    利用队列的先进先出规则
    */

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node curr = queue.remove();
                if (i > 0) pre.next = curr; //从第二个节点开始，将节点连接起来
                pre = curr;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
}
