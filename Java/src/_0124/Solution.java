package _0124;

import structures.TreeNode;

public class Solution {

    /*
    直接抄的题解，需要背一下：
    maxGain计算一个顶点和子树加起来的最大贡献（这个顶点不一定包含root，因此需要在递归中不断确定是否要包含递归到的节点）
    */

    public int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        //计算左子树和右子树的最大贡献
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        //计算是否当前节点是结果的最高节点（是的话那么左右两树都要加）
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        //返回当前节点的数值+左右两树的max值
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

}
