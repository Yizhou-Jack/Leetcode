package Leetcode._0112;

import structures.TreeNode;

public class Solution1 {

    public static int target;

    public static boolean hasPathSum(TreeNode root, int sum) {
        target = sum;
        return helper(root, 0);
    }

    public static boolean helper(TreeNode node, int sum) {
        if (node == null) return false;
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == target;
        } else {
            return helper(node.left, sum) || helper(node.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2]");
        boolean res = hasPathSum(root, 1);
        System.out.println(res);
    }
}
