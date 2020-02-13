package _0437;

import structures.TreeNode;

public class Solution1 {

    /*
    res一直在累加在这个节点上能够找到的结果数量，随着层级增高一点点累加
    双递归
     */

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int a = paths(root, sum); //数经过root的结果个数
        int b = pathSum(root.left, sum); //在递归中调用到paths(root.left, sum)，数经过root.left的结果个数
        int c = pathSum(root.right, sum); //在递归中调用到paths(root.right, sum)，数经过root.right的结果个数
        return a+b+c;
    }

    private static int paths(TreeNode root, int sum) {
        if (root == null) return 0;

        int res = 0;
        if (root.val == sum) {
            res += 1;
        }

        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int res = pathSum(root, 8);
        //System.out.println(res);
    }
}
