package _0069;

public class Solution1 {

    /*
    使用二分查找模板的找右中位数方法
    */

    public static int mySqrt(int x) {
        long left = 0;
        long right = x/2 + 1;
        while (left < right) {
            long mid = left + (right + 1 - left) / 2; //二分查找，找右中位数
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        int res = mySqrt(99999);
        System.out.println(res);
    }
}
