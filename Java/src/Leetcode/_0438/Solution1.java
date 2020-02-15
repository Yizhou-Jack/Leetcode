package Leetcode._0438;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    /*
    滑动窗口：
    右移两个指针，每次都比较两个数组是否相等
    */

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;

        int[] compareMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            compareMap[p.charAt(i)-'a']++;
        }

        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[s.charAt(i)-'a']++;
        }
        int i = 0;
        int j = p.length()-1;
        while (j < s.length()) {
            if (checkValid(compareMap, map)) {
                res.add(i);
            }
            j++;
            if (j < s.length()) {
                map[s.charAt(i)-'a']--;
                map[s.charAt(j)-'a']++;
            }
            i++;
        }

        return res;
    }

    private static boolean checkValid(int[] compareMap, int[] map) {
        for (int i = 0; i < compareMap.length; i++) {
            if (compareMap[i] != map[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("aa", "bb");
        System.out.println(res.toString());
    }
}
