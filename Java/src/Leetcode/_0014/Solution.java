package Leetcode._0014;

public class Solution {

    /*
    res为一直在变换的common prefix。初始值为strs[0]。
    从第二个strs中的str开始检查res与str的prefix，每次循环都会更新res，
    如果res为""，那么直接返回；如果存在字符串，那么返回字符串。
    */

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.equals("") || res.equals("")) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < str.length() && str.charAt(start) == res.charAt(start)) {
                start++;
            }
            res = res.substring(0, start);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] sArray = new String[]{"flower", "flow", "fly"};
        String commonPrefix = longestCommonPrefix(sArray);
        System.out.println(commonPrefix);
    }

}
