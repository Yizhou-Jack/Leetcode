package Leetcode._0168;

public class Solution1 {

    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--; //从1开始
            stringBuilder.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String res = convertToTitle(26);
        System.out.println(res);
    }
}
