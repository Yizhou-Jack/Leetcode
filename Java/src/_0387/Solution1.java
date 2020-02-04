package _0387;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++num);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;
        }
        return -1;
    }
}
