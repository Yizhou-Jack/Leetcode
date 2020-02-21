package Leetcode._0772;

import java.util.Stack;

public class Solution2 {

    public int calculate(String s) {
        return simpleCalculate(s, 0)[0];
    }
    /**
     * 加上括号的处理方式。
     * @param s
     * @param begin 从begin开始处理
     * @return 返回数组，第一个表示结果，第二个表示s处理的位置。
     */
    public int[] simpleCalculate(String s, int begin) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int i = begin;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + (c-'0');
            }
            if (c == '(') {
                //左括号开始递归，返回括号的运算结果和处理位置
                int[] temp = simpleCalculate(s, i+1);
                //运算结果赋值给num，sign不变。i更新到括号外围继续运算。相当于用运算结果替换了括号表达式
                num = temp[0];
                i = temp[1] + 1;
                //括号在末尾时，到了表达式末尾，需要做一次运算
                if (i == s.length()) {
                    calProcess(stack, num, sign);
                }
                continue;
            } else if (c == ')') {
                //右括号代表表达式末尾，需要做一次运算
                calProcess(stack, num, sign);
                break;
            } else if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                //正常的四则运算
                calProcess(stack, num, sign);
                sign = c;
                num = 0;
            }
            i++;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return new int[]{ans, i};
    }

    private void calProcess(Stack<Integer> stack, int num, char sign) {
        switch (sign) {
            case '-' :
                stack.push(0-num);
                break;
            case '+' :
                stack.push(num);
                break;
            case '*' :
                stack.push(stack.pop() * num);
                break;
            case '/' :
                stack.push(stack.pop()/num);
                break;
        }
    }
}
