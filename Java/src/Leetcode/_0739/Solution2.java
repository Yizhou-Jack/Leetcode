package Leetcode._0739;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) { //stack为空的话，push进去
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                if (T[stack.peek()] >= T[i]) { //比较栈顶元素index在T中的温度，栈顶index代表的温度比当前遍历到的温度要高则继续push
                    stack.push(i);
                    break;
                } else {
                    int index = stack.pop(); //否则pop出来，index相减则为需要等待的天数
                    res[index] = i-index;
                }
            }
            if (stack.isEmpty()) stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(intArr);
        System.out.println(Arrays.toString(res));
    }
}
