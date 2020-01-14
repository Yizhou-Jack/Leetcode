package _0098;

import structures.TreeNode;

import java.util.Stack;

public class Solution3 {

    /*
    利用中序遍历的性质：
    中序遍历时，如果这是一个二叉搜索树，那么先遍历到的值一定会小于后遍历到的值。
    */

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
