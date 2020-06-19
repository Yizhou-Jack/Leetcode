package Leetcode._0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //滑动窗口法
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        for (int end = 0; end < len; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start); //get的是最近的一个重复出现字母的后一位字母的index
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1); //put的是后一位字母的index
        }
        return res;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abcbc");
        System.out.println(length);
    }

}
