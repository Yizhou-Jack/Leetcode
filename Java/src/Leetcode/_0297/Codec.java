package Leetcode._0297;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    /*
    自己写的智障方法
     */

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String res = "[";
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res = res + "null,";
                continue;
            }
            res = res + node.val + ",";
            queue.add(node.left);
            queue.add(node.right);
        }
        while (true) {
            if (res.length() > 5 && res.substring(res.length()-5).equals("null,")) {
                res = res.substring(0,res.length()-5);
            } else {
                break;
            }
        }
        return res.substring(0,res.length()-1)+"]";
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;

        String[] strArr = data.substring(1,data.length()-1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty() && i < strArr.length) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            TreeNode left = null;
            TreeNode right = null;
            if (i+1 < strArr.length) {
                left = strArr[i+1].equals("null") ? null : new TreeNode(Integer.parseInt(strArr[i+1]));
            }
            if (i+2 < strArr.length) {
                right = strArr[i+2].equals("null") ? null : new TreeNode(Integer.parseInt(strArr[i+2]));
            }
            node.left = left;
            node.right = right;
            queue.add(left);
            queue.add(right);
            i = i+2;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode output = deserialize("[1,null,2]");
        String input = serialize(output);
        System.out.println(input);
    }
}
