package Leetcode._0050;

public class Solution2 {

    /*
    递归法
    */

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            long N = n;
            return getRes(x, N);
        } else {
            double xInv = 1/x;
            long minusN = -n;
            return getRes(xInv, minusN);
        }
    }

    private static double getRes(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = getRes(x, n/2);
        if (n % 2 == 0) {
            return half*half;
        } else {
            return half*half*x;
        }
    }

    public static void main(String[] args) {
        double res = myPow(2.1, 2);
        System.out.println(res);
    }
}
