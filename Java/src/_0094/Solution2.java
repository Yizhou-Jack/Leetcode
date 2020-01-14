package _0094;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /*
    莫里斯二叉树遍历法
    */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {//左子树为空，输出当前节点，将其右孩子作为当前节点
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                pre = cur.left;//左子树
                while (pre.right != null && pre.right != cur) {//找到前驱节点，即左子树中的最右节点
                    pre = pre.right;
                }
                //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                //如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
                if (pre.right == cur) {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
