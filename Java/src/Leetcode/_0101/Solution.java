package Leetcode._0101;

import structures.TreeNode;

public class Solution {

    /*
    递归写法：
    左右对称，即为根节点相同，左子树和另一棵树的右子树相同，右子树和另一棵树的左子树相同
    */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

}
