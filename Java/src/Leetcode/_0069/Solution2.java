package Leetcode._0069;

public class Solution2 {

    /*
    数学方法：牛顿法
    */

    public static int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    public static void main(String[] args) {
        int res = mySqrt(99999);
        System.out.println(res);
    }

}
