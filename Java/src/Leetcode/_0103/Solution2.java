package Leetcode._0103;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    /*
    迭代解法
    */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        int level = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            res.add(new ArrayList<>());
            TreeNode node = null;
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    node = stack1.pop();
                    res.get(level).add(node.val);
                    if (node.left != null) stack2.push(node.left); //先left后right
                    if (node.right != null) stack2.push(node.right);
                }
                level++;
            } else {
                while (!stack2.isEmpty()) {
                    node = stack2.pop();
                    res.get(level).add(node.val);
                    if (node.right != null) stack1.push(node.right); //先right后left
                    if (node.left != null) stack1.push(node.left);
                }
                level++;
            }
        }
        return res;
    }

}
