package Leetcode._0669;

import structures.TreeNode;

public class Solution1 {

    /*
    如果当前节点的值大于R，那么修剪后的二叉树必定出现在节点的左边；
    如果当前节点的值小于L，那么修剪后的二叉树必定出现在节点的右边；
    否则修剪节点的两边
     */

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
