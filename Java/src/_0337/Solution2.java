package _0337;

import structures.TreeNode;

public class Solution2 {

    /*
    helper函数返回一个int数组，result[0]代表这个节点不偷，result[1]代表这个节点偷
    */

    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
