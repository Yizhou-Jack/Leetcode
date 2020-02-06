package _0032;

import java.util.Stack;

public class Solution1 {

    /*
    栈解法：
    遇到一个(，把(放到栈顶；
    遇到一个)，先pop。如果栈内没有值了，那么将其push进去（不断的更新最近的)的index）
                    如果有值，那么就计算peek所在的(的index与目前遍历到的index的差值
    算法设计很妙
    */

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i-stack.peek());
                }
            }
        }
        return res;
    }
}
