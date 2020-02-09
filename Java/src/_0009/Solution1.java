package _0009;

public class Solution1 {

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        boolean res = isPalindrome(1001);
        System.out.println(res);
    }
}
