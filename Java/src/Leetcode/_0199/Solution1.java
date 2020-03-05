package Leetcode._0199;

import javafx.util.Pair;
import structures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, root));
        int depth = 0;
        while (!queue.isEmpty()) {
            int flag = 0;
            while (!queue.isEmpty()) {
                if (queue.peek().getValue() == null) {
                    queue.poll();
                } else if (queue.peek().getKey() == depth && flag == 0) {
                    Pair<Integer, TreeNode> pair = queue.poll();
                    res.add(pair.getValue().val);
                    queue.add(new Pair<>(depth+1, pair.getValue().right));
                    queue.add(new Pair<>(depth+1, pair.getValue().left));
                    flag = 1;
                } else if (queue.peek().getKey() == depth && flag == 1) {
                    Pair<Integer, TreeNode> pair = queue.poll();
                    queue.add(new Pair<>(depth+1, pair.getValue().right));
                    queue.add(new Pair<>(depth+1, pair.getValue().left));
                } else break;
            }
            depth++;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,3,null,5,null,4]");
        List<Integer> res = rightSideView(root);
        System.out.println(res);
    }
}
