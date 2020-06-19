package Leetcode._0394;

import java.util.Stack;

public class Solution1 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') { //push数字位,push[之前的字符串
                stackMulti.push(multi);
                stackRes.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stackMulti.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackRes.pop() + tmp);
            }
            else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
