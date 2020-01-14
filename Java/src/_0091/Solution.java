package _0091;

public class Solution {

    /*
    动态规划方法：
    首先需要发现以下规律：如果从末尾开始遍历字符串，1. 如果遍历到的数字为0，那么解法个数为0
                                           2. 如果遍历到的数字和遍历到的数字的右边一位数小于等于26，那么解法个数为遍历到的数字右边一位数+遍历到的数字右边两位数
                                           3. 如果遍历到的数字和遍历到的数字的右边一位数大于26，那么解法个数为遍历到的数字右边一位数
    维护一个dp数组，从后向前按照上述规则填满至dp[0]
    */

    public static int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1; //设计为前面累加所用
        if (s.charAt(len-1) == '0') { //判断最末尾的数字能够提供几种解法：1/0
            dp[len-1] = 0;
        } else {
            dp[len-1] = 1;
        }

        for (int i = len-2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0') <= 26) { //判断i与i右边的一位数是否小于等于26
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int res = numDecodings("226");
        System.out.println(res);
    }
}
