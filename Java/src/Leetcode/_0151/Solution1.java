package Leetcode._0151;

public class Solution1 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        for (int i = strArr.length-1; i >= 0; i--) {
            String str = strArr[i];
            if (!str.equals("")) {
                sb.append(str);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String res = reverseWords(" ");
        System.out.println(res);
    }
}
