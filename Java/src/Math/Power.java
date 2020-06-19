package Math;

public class Power {

    /*
    当幂数为偶数时：比如2^8 = 2^4 * 2^4
                    2^4 = 2^2 * 2^2
                    2^2 = 2^1 * 2^1
     */

    public static long power(long a,int n){
        long res = 1;
        while (n != 0) {
            if (n%2 == 1) res *= a;
            a *= a;
            n = n/2;
        }
        return res;
    }

    public static long powerRecursion(long a, int n) {
        if (n == 0) return 1;
        long res = powerRecursion(a, n/2);
        if (n%2 == 1) {
            return res*res*a;
        } else {
            return res*res;
        }
    }

    public static void main(String[] args) {
        long res = power(2, 8);
        System.out.println(res);
    }

}
