package _0005;

public class Solution {

    /*
    暴力解法：O(n^3)
    列举所有的字串 --> 两层for循环 --> O(n^2)
    在第二层for循环中检查是否为回文字符串 --> O(n*n^2) --> O(n^3)
    */
    /*
    动态规划优化了暴力解法：将之前算过的是否为回文字符串的结果保存下来。
    首先定义P[i,j]：true则s[i,j]是回文串；false则s[i,j]不是回文串。
    易得P(i,j)=(P(i+1,j−1)&&S[i]==S[j])，所以如果先前保存了P(i+1,j−1)的结果，那么只用比较S[i]==S[j]就可以判断是否为回文串了。
    所以我们先初始化长度为1的所有回文串和长度为2的所有回文串，
    之后动态规划算法就可以使用长度1和长度2的回文串结果，来扩展长度3,5,7...和长度4,6,8...的回文串结果
    */

    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                if (len == 1 || len == 2){ //长度为 1 和 2 的单独判断
                    P[start][end] = s.charAt(start) == s.charAt(end);
                }
                else {
                    P[start][end] = (P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                }
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    public static void main(String[] args) {
        String strS = "abccbaccjwcndd";
        String maxPal = longestPalindrome(strS);
        System.out.println(maxPal);
    }
}
