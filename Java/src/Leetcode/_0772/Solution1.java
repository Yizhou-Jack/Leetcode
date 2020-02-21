package Leetcode._0772;

import java.util.Stack;

public class Solution1 {

    /*
    自己写的，很麻烦，并且还有些用例过不了
     */

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (c.equals(")")) {
                System.out.println("signal");
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.insert(0, stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); //去掉(
                System.out.println(sb.toString());
                int intSubRes = noBracket(sb.toString());
                if (intSubRes < 0) {
                    Stack<String> tempStack = new Stack<>();
                    while (!stack.isEmpty()) {
                        String str = stack.pop();

                        if (!str.equals("+") && !str.equals("-")) {
                            tempStack.push(str);
                        } else {
                            if (str.equals("+")) {
                                stack.push("-");
                                while (!tempStack.isEmpty()) {
                                    stack.push(tempStack.pop());
                                }
                                stack.push(String.valueOf(-intSubRes));
                                break;
                            }
                            if (str.equals("-")) {
                                stack.push("+");
                                while (!tempStack.isEmpty()) {
                                    stack.push(tempStack.pop());
                                }
                                stack.push(String.valueOf(-intSubRes));
                                break;
                            }
                        }
                    }
                    if (stack.isEmpty()) stack.push(String.valueOf(intSubRes));
                } else {
                    stack.push(String.valueOf(intSubRes));
                }
                System.out.println(intSubRes);
            } else {
                if (!c.equals(" ")) stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        System.out.println(sb.toString());
        int res = noBracket(sb.toString());
        return res;
    }

    public static int noBracket(String s) {
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
            i = ret[1];
        }
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
            num = 10*num + s.charAt(i++)-'0';
        }
        return new int[]{num, i-1};
    }

    public static void main(String[] args) {
        int res = calculate("66-((-3)+3)");
        //3-(2+(9-(0-(8-(2)))))
        System.out.println(res);
    }
}
