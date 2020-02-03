package _0344;

public class Solution1 {

    public static void reverseString(char[] s) {
        int len = s.length;
        if (len == 1) return;
        for (int i = 0; i < s.length/2; i++) {
            char tmp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] charArr = "sbycg".toCharArray();
        reverseString(charArr);
        System.out.println(charArr);
    }
}
