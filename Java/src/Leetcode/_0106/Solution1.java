package Leetcode._0106;

import structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /*
    抄的：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
     */

    Map<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = helper(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode helper(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = helper(is, ri - 1, ps, ps + ri - is - 1);
        node.right = helper(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }

}
