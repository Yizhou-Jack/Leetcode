package Leetcode._0029;

public class Solution {

    /*
    如果只是简单的累减，会导致超时。
    优化的方法是采用递归：
    每次减去除数的时候，给除数增倍，直到增倍的除数无法被减去；
    无法被减去后就开始新的一轮，此时的被除数为a-b。
    */

    public static int divide(int dividend, int divisor) {
        int flag = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            flag = 1;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        return flag*getRes(dividend, divisor);
    }

    private static int getRes(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tmp = b;
        System.out.println("-----");
        System.out.println(a);
        System.out.println(b);
        System.out.println("-----");
        while (a < b << 1) { //二进制码左移一位，即b*2
            b = b << 1;
            count = count << 1; //二进制码左移一位，即count*2
        }
        System.out.println("=====");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a-b);
        System.out.println("=====");
        return count + getRes(a - b, tmp);
    }

    public static void main(String[] args){
        int dividend = 2147483647;
        int divisor = 3;
        int res = divide(dividend, divisor);
        System.out.println(res);
    }
}
