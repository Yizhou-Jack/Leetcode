package Leetcode._0572;

import structures.TreeNode;

public class Solution1 {

    public boolean isEqual(TreeNode l, TreeNode r){
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val == r.val) return isEqual(l.left, r.left) && isEqual(l.right, r.right);
        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
}
