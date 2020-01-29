package _0236;

import structures.TreeNode;

public class Solution1 {

    private static TreeNode res = null;

    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) return false;

        int left = recurseTree(currentNode.left, p, q) ? 1 : 0; //left表示向左子树递归是否能找到通向p/q，能找到赋值1，不能的话赋值0
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0; //right表示向右子树递归是否能找到通向p/q，能找到赋值1，不能的话赋值0
        int mid = (currentNode == p || currentNode == q) ? 1 : 0; //mid表示当前节点是否等于p/q，等于的话赋值1，不等于赋值0
        if (mid + left + right == 2) { //只要其中两个值=1当前节点便是公共祖先节点
            res = currentNode;
        }
        return (mid + left + right > 0);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTestData("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode res = lowestCommonAncestor(tree, tree.left, tree.left.right.right);
        System.out.println(res.val);
    }
}
