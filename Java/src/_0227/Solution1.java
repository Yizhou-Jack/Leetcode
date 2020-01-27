package _0227;

import java.util.Stack;

public class Solution1 {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char ch;
        int[] ret;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == ' ') continue;
            ret = getNextNumber(s, i);
            if (Character.isDigit(ch) || ch == '+') {
                stack.push(ret[0]);
            } else if (ch == '-') {
                stack.push(-ret[0]);
            } else if (ch == '*') {
                stack.push(stack.pop() * ret[0]);
            } else if (ch == '/') {
                stack.push(stack.pop() / ret[0]);
            }
            i = ret[1]; //调整索引：获得的下一个数字的末尾索引
        }
        //返回计算结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static int[] getNextNumber(String s, int i) {
        int num = 0;
        while (!Character.isDigit(s.charAt(i))) {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = 10*num + s.charAt(i++)-'0'; //s.charAt(i++) 等于 s.charAt(i); i++;
        }
        return new int[]{num, i-1}; //返回得到的数字及该数字最后一个数字字符的索引
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }
}
