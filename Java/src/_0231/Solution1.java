package _0231;

public class Solution1 {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1 || n == 2) return true;

        long num = 2;
        while (num < n) {
            num *= num;
            if (num == n) return true;
        }
        while (num > n) {
            num /= 2;
            if (num == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = isPowerOfTwo(1073741825);
        System.out.println(res);
    }
}
