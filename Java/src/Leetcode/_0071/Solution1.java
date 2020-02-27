package Leetcode._0071;

import java.util.Stack;

public class Solution1 {

    public static String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strArr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = simplifyPath("/a/./b/../../c/");
        System.out.println(res);
    }
}
