package _0049;

import java.util.*;

public class Solution {

    /*
    记录字符出现的次数，如果两个str的字符出现次数相同，那么就是同位词。
    */

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> res = new HashMap<>();
        int[] counts = new int[26];
        for (String s : strs) {
            Arrays.fill(counts, 0);
            for (char c : s.toCharArray()) {
                counts[c-'a']++; //获得一个落在0-25之间的数字
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(counts[i]);
            }
            String key = sb.toString();
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc","acb","bca","add","dda","ccc"};
        List<List<String>> res = groupAnagrams(strs);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("-----");
        }
    }
}
