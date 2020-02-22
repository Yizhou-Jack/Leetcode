package Leetcode._0636;

import java.util.List;
import java.util.Stack;

public class Solution1 {

    /*
    遇到包含start的日志时，将对应函数的id入栈；遇到包含end的日志时，将对应函数的id出栈。
     */

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1;
        int prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) { //如果包含start，先将栈顶函数的时间与prev相减计算中间这段运行时间，加到原来的运行时间上
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0])); //将最新的函数id压入栈中
                prev = Integer.parseInt(s[2]); //更新prev
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1; //如果包含end，那么栈顶元素就是当前被执行的函数
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}
