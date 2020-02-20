package Leetcode._0186;

import java.util.Arrays;

public class Solution1 {

    public static void reverseWords(char[] s) {
        if (s.length == 0) return;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }

        int left = 0;
        int right = 0;
        while (left < s.length) {
            while (right < s.length-1 && s[right+1] != ' ') {
                right++;
            }
            for (int i = left; i < left+(right-left+1)/2; i++) {
                char temp = s[i];
                s[i] = s[left+right-i];
                s[left+right-i] = temp;
            }
            right += 2;
            left = right;
        }
    }

    public static void main(String[] args) {
        char[] charArr = new char[]{'b','l','u','e',' ','i','s',' ','n','i','m','o','m'};
        reverseWords(charArr);
        System.out.println(Arrays.toString(charArr));
    }
}
