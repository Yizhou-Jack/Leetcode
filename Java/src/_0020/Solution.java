package _0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /*
    利用stack
    */

    public static boolean isValid(String s) {
        //创建mapping的hashmap
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        //创建stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果循环找到的c是个右括号，那么就在stack中找它pop出的element是否配对
            if (map.containsKey(c)) {
                char topElement = '*'; //初始设置为一个无法配对的*
                if (!stack.isEmpty()){
                    topElement = stack.pop();
                }
                //如果不能够配对，那么就不是合法的括号组
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c); //如果循环找到的c是个左括号，那么将其push入stack
            }
        }
        //如果最后stack里还有括号，那么就不是合法的括号组
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
