package _0103;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    递归方法：
    和第102题一样，只需要多加一个判断level的条件：奇数时添加在末尾，偶数时添加在开头
    */

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return res;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode node, int level) {
        if (level > res.size()) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 1) {
            res.get(level-1).add(node.val);
        } else {
            res.get(level-1).add(0, node.val); //将元素添加在开头
        }

        if (node.left != null) helper(node.left, level+1);
        if (node.right != null) helper(node.right, level+1);
    }
}
