package Leetcode._0443;

import java.util.Arrays;

public class Solution1 {

    public static int compress(char[] chars) {
        int anchor = 0; //记录当前字符
        int res = 0; //记录写到char数组的什么位置
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) { //发现read的下一个字符和当前read字符不一样
                chars[res] = chars[anchor]; //把anchor所记录的字符写到write上
                res++; //准备开始写字符的个数
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[res] = c;
                        res++;
                    }
                }
                anchor = read + 1; //把锚点放到read的后一位
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','c','d','c'};
        int res = compress(chars);
        System.out.println(Arrays.toString(chars));
    }
}
