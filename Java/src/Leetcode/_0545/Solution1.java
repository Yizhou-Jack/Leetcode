package Leetcode._0545;

import structures.TreeNode;

import java.util.*;

public class Solution1 {

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode node = root;
        res.add(node.val);
        if (node.left != null) {
            node = node.left;
            while (node.left != null || node.right != null) {
                res.add(node.val);
                node = node.left == null ? node.right : node.left;
            }
        }
        //System.out.println(res);

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stackRes = new Stack<>();
        if (root.left != null) stack1.add(root.left);
        if (root.right != null) stack1.add(root.right);
        while (!stack1.isEmpty()) {
            TreeNode nowNode = stack1.pop();
            if (nowNode.right == null && nowNode.left == null) {
                stackRes.add(nowNode.val);
            }
            if (nowNode.left != null) stack1.add(nowNode.left);
            if (nowNode.right != null) stack1.add(nowNode.right);
        }
        while (!stackRes.isEmpty()) {
            res.add(stackRes.pop());
        }
        //System.out.println(res);

        if (root.right == null) {
            return res;
        } else {
            Stack<Integer> stack2 = new Stack<>();
            node = root.right;
            while (node.left != null || node.right != null) {
                stack2.add(node.val);
                node = node.right == null ? node.left : node.right;
            }
            while (!stack2.isEmpty()) {
                int subres = stack2.pop();
                res.add(subres);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,7,3,5,null,6,4]");
        List<Integer> res = boundaryOfBinaryTree(root);
        System.out.println(res);
    }
}
