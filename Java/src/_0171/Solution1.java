package _0171;

public class Solution1 {

    /*
    遍历时将每个字母与A做减法，因为A表示1，所以减法后需要每个数加1
    因为有26个字母，所以相当于26进制，每26个数则向前进一位
    每遍历一位则ans = ans * 26 + num
    */

    public static int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
