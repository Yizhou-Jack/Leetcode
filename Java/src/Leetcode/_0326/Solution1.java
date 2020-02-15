package Leetcode._0326;

public class Solution1 {

    public static boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        double dn = Double.valueOf(n);
        while (dn > 1) {
            dn /= 3;
            if (dn == 1.0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = isPowerOfThree(27);
        System.out.println(res);
    }
}
