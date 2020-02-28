package Leetcode._0110;

import structures.TreeNode;

public class Solution1 {

    public boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left) + 1;
        int right = helper(node.right) + 1;
        if (Math.abs(left-right) > 1) flag = false;
        return Math.max(left, right);
    }
}
