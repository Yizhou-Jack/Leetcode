package Leetcode._0647;

public class Solution2 {

    /*
    中心扩展法：
    如果一个字符串不是回文串，那么他左右两边再多加字符也不会是回文串。
    再分奇数回文串和偶数回文串（countPalindrome(s, i, i)和countPalindrome(s, i, i + 1)）
    */

    public int countSubstrings(String s) {
        int count = 0;
        int i;
        for(i = 0; i < s.length(); i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    public int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) { //找到非回文串后立刻终止
            count++;
        }
        return count;
    }

}
