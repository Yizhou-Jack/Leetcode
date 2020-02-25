package Leetcode._0093;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        backtrack(0, "", 4, s, n);
        return res;
    }

    private void backtrack(int i, String tmp, int flag, String s, int n) {
        if (i == n && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1)); //把最后面的.去掉
            return;
        }
        if (flag < 0) return; //flag记录出现了几个.
        for (int j = i; j < i + 3; j++) { //只考虑后三位数字
            if (j < n) {
                if (i == j && s.charAt(j) == '0') { //一位0是可以的
                    backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, n);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255) {
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, n);
                }
            }
        }
    }
}
