package Leetcode._0402;

import java.util.Stack;

public class Solution1 {

    /*
    给定一个数字序列[D1,D2,D3,D4...]，如果D2小于左邻居D1，那么我们应该删除D1，以获得最小解。
    对于每个数字，如果该数字小于栈顶部，则弹出堆栈（删除左邻居），否则我们把数字推到堆栈上；
    重复以上步骤，直到堆栈为空或者已经删除了k个数字
     */

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.push(digit);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}
