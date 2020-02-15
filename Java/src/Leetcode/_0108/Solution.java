package Leetcode._0108;

import structures.TreeNode;

public class Solution {

    /*
    递归解法：
    ***需要记住：中序遍历一棵二叉搜索树的结果，是一个从小递增的数列***
    那么root的值就是这棵二叉搜索树数列的中点值。
    ***在参数中加上treenode无法新建leftnode和rightnode，新建node需要new出来***
    */

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    public static TreeNode helper(int[] nums, int start, int end) {
        if (start == end) return null;

        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode res = sortedArrayToBST(nums);
        res.print(res);
    }
}
