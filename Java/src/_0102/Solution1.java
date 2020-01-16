package _0102;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    /*
    递归写法：
    res用于最终结果的返回，里面元素的index就是层数。在递归函数中有层数这个参数，往下搜索子树时累加这个参数
    */

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode node, int level) {
        if (level > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(node.val);

        if (node.left != null) helper(node.left, level+1);
        if (node.right != null) helper(node.right, level+1);
    }
}
