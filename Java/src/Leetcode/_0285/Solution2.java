package Leetcode._0285;

import structures.TreeNode;

public class Solution2 {

    /*
    如果当前值小于等于x，那么根据BST的特性，只需要在右子树找；
    如果当前值大于x，则当前值有可能有更小的并且大于x的。那么每次走入这个分支时，当前点是一个候选值，我们记录下历史最小值并返回。
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) {
            return null;
        }
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val <= p.val) {
                cur = cur.right;
            } else {
                if (res == null || res.val > cur.val) {
                    res = cur;
                }
                cur = cur.left;
            }
        }
        return res;
    }
}
