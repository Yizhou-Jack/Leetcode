package Leetcode._0098;

import structures.TreeNode;

public class Solution1 {

    /*
    递归法：
    在递归中保存树的上界和下界，如果递归中的新树的val超出了上下界，那么就return false
    */

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

}
