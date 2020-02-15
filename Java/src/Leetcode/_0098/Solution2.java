package Leetcode._0098;

import structures.TreeNode;

import java.util.Stack;

public class Solution2 {

    /*
    利用栈的迭代法
    */

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> uppers = new Stack<>();
    Stack<Integer> lowers = new Stack<>();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST(TreeNode root) {
        Integer lower = null;
        Integer upper = null;
        Integer val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.pop();
            lower = lowers.pop();
            upper = uppers.pop();

            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }
}
