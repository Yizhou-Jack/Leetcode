package Leetcode._0557;

public class Solution1 {

    /*
    也可以直接使用string builder的reverse功能（将string append到sb里边，然后reverse）
    */

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            for (int j = strArr[i].length()-1; j >= 0; j--) {
                sb.append(strArr[i].charAt(j));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = reverseWords("Let's take LeetCode contest");
        System.out.println(res);
    }
}
