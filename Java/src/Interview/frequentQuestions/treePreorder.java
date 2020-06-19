package Interview.frequentQuestions;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class treePreorder {

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //将自己放入res，迭代访问节点的左节点并入栈
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //迭代至没有左节点之后，pop出一个节点并访问它的右节点
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6,7,8,9]");
        List<Integer> res = preorder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
