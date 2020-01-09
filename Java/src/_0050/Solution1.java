package _0050;

public class Solution1 {

    /*
    暴力法
    */

    public static double myPow(double x, int n) {
        double res = 1;
        if (n == 0) {
            return res;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
            return res;
        } else {
            double xInv = 1/x;
            int minusn = -n;
            for (int i = 0; i < minusn; i++) {
                res = res * xInv;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        double res = myPow(2.1, 2);
        System.out.println(res);
    }
}
