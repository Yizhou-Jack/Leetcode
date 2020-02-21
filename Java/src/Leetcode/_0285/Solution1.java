package Leetcode._0285;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<TreeNode> treeTraversal = new ArrayList<>();

    public void inorder(TreeNode root) { //中序遍历
        if (root == null) {
            return;
        }
        inorder(root.left);
        treeTraversal.add(root);
        inorder(root.right);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);
        for (int i = 0; i < treeTraversal.size(); i++) {
            if (treeTraversal.get(i) == p) {
                if (i+1 >= treeTraversal.size()) {
                    return null;
                } else {
                    return treeTraversal.get(i+1);
                }
            }
        }
        return null;
    }
}
