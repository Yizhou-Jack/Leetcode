package Leetcode._0543;

import structures.TreeNode;

public class Solution1 {

    public int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return Math.max(res-1, 0);
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        res = Math.max(res, left+right+1);
        return Math.max(left+1, right+1);
    }
}
