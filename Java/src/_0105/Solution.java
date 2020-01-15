package _0105;

import structures.TreeNode;

import java.util.HashMap;

public class Solution {

    /*
    递归解法：
    preorder的第一个元素是root节点，那么可以在inorder中找到root节点val的位置，左边的元素就是左子树，右边的元素就是右子树。
    在知道了左边的元素的长度leftNum之后，preorder排除root节点向右leftNum的长度，就是左子树的所有元素，其中第一个元素就是root，
    右子树就是排除root+leftNum长度，剩下的元素就是右子树的所有元素，其中第一个元素就是root
    */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>(); //将inorder的元素都保存起来，方便之后查找
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
                                     HashMap<Integer, Integer> map) {
        if (pStart == pEnd) { //如果这段preorder为空，那么就已经到达叶子节点
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int iRootIndex = map.get(rootVal);
        int leftNum = iRootIndex - iStart;
        root.left = helper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex, map);
        root.right = helper(preorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd, map);
        return root;
    }
}
