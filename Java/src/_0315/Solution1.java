package _0315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ret = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = 0;
        }
        List<Integer> list = new ArrayList<>();
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, new TreeNode(nums[i]), ret, i);
        }
        return Arrays.asList(ret);
    }

    public TreeNode insert(TreeNode root, TreeNode node, Integer[] ret, int i) {
        if (root == null) {
            root = node;
            return root;
        }
        if (root.val >= node.val) { //大于等于插入到左子树，防止多加1
            root.count++;
            root.left = insert(root.left, node, ret, i);
        } else {
            ret[i] += root.count + 1;
            root.right = insert(root.right, node, ret, i);
        }
        return root;
    }
}

class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
        count = 0;
    }
}

