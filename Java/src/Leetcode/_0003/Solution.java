package Leetcode._0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //滑动窗口法
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start); //put相同的值覆盖，get的是最近的一个重复出现字母
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1); //put相同的值而覆盖
        }
        return ans;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("hsggggduuwhdgsuiu");
        System.out.println(length);
    }

}
