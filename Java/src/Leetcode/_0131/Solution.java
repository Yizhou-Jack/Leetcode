package Leetcode._0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        List<String> list = new ArrayList<>();
        helper(s, list,0, dp);
        return res;
    }

    public void helper(String s, List<String> list, int index, boolean[][] dp){
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i);
            if (dp[index][i]) {
                list.add(str);
                helper(s, list, i, dp);
                list.remove(list.size()-1);
            }
        }
    }
}
