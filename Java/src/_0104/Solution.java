package _0104;

import structures.TreeNode;

public class Solution {

    /*
    递归方法：
    和102类似，一直比较res的大小，level大于它则更新res
    */

    public int res = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return res;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode node, int level) {
        if (level > res) res = level;

        if (node.left != null) helper(node.left, level+1);
        if (node.right != null) helper(node.right, level+1);
    }
}
