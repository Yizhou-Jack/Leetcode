package Leetcode._0538;

import structures.TreeNode;

public class Solution1 {

    /*
    反序中序遍历
    */

    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
