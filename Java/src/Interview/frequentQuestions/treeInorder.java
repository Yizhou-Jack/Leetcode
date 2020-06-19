package Interview.frequentQuestions;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class treeInorder {

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //迭代访问节点的左节点并入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //迭代至没有左节点之后，pop出一个节点，将节点的值放入res并访问它的右节点
            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6,7,8,9]");
        List<Integer> res = inorder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
