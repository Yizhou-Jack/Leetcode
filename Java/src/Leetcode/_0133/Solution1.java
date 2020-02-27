package Leetcode._0133;

import java.util.*;

public class Solution1 {

    public Node cloneGraph(Node node) {
        if (node == null) return node;

        HashMap<Node, Node> visited = new HashMap(); //原node和copy node的一一对应
        LinkedList<Node> queue = new LinkedList<>(); //储存原nodes
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor: n.neighbors) { //遍历pop出来的原node的neighbors
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                //visited.get(n).neighbors: pop出来的原node的对应copy node的neighbors添加 原node的neighbors
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
