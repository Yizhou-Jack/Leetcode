package Leetcode._0094;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    /*
    二叉树中序遍历模板
    */

    public List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
