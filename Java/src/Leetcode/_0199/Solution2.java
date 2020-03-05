package Leetcode._0199;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

    public List<Integer> rightSideView(TreeNode root) {
        //层次遍历，将每层的最后一个节点的值放入List<Integer>中
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //用于放节点的队列
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(root);
        while (!queueNode.isEmpty()) {
            int size = queueNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queueNode.poll();
                if (t.left != null) queueNode.add(t.left);
                if (t.right != null) queueNode.add(t.right);
                //每层队列的最后一个元素的值，放入res
                if (i == size - 1) res.add(t.val);
            }
        }
        return res;
    }
}
