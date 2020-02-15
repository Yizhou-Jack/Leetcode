package Leetcode._0204;

public class Solution1 {

    /*
    超时，但是判断prime的checkPrime函数可以这样写（到sqrtN）
    */

    public static int countPrimes(int n) {
        if (n == 1 || n == 0 || n == 2) return 0;
        if (n == 3) return 1;
        if (n == 4) return 2;
        int res = 2;
        for (int i = 5; i < n; i++) {
            boolean subRes = checkPrime(i);
            if (subRes) res++;
        }
        return res;
    }

    public static boolean checkPrime(int n) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int res = countPrimes(7);
        System.out.println(res);
    }
}
