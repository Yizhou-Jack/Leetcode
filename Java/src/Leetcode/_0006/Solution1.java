package Leetcode._0006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            sbList.add(new StringBuilder());
        }

        int curRow = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            sbList.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows-1) flag = !flag;
            curRow += flag ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sbList.size(); i++) {
            sb.append(sbList.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 5;
        String res = convert(s, numRows);
        System.out.println(res);
    }
}
