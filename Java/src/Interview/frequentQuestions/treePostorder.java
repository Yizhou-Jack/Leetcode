package Interview.frequentQuestions;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class treePostorder {

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisited = null;
        while (node != null || !stack.isEmpty()) {
            //迭代访问节点的左节点并入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                //如果右节点是空，那么将这个节点加入res。
                //node.right == lastVisited是为了避免重复访问右节点：如果已经访问过这个右节点，那么这次直接把根节点加入res
                if (node.right == null || node.right == lastVisited) {
                    res.add(node.val);
                    lastVisited = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6,7,8,9]");
        List<Integer> res = postorder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
