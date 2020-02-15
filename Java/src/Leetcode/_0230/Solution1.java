package Leetcode._0230;

import structures.TreeNode;

import java.util.ArrayList;

public class Solution1 {

    /*
    中序遍历得到的是从小到大排列的一个序列，那么选list中k-1位置的数字即是第k小的数字
    */

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

}
