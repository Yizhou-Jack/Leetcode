package _0337;

import structures.TreeNode;

public class Solution1 {

    public int rob(TreeNode root) {
        if (root == null) return 0;

        int money = root.val; //爷爷的钱
        if (root.left != null) { //左子树两个孙子的钱
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) { //右子树两个孙子的钱
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.left)+rob(root.right)); //和两个儿子的钱作比较
    }
}
