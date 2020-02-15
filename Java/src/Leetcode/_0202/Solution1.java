package Leetcode._0202;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    /*
    也可以不使用set来储存：使用快慢双指针来判断有没有循环（UNDO）
    */

    /*
    先转成字符串，然后charAt来遍历。
    也可以：
    while (n != 0) {
        num = n%10;
        n /= 10;
        sum += num*num;
    }
    */

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;

        while (true) {
            String strNum = String.valueOf(num);
            num = 0;
            for (int i = 0; i < strNum.length(); i++) {
                int tmp = strNum.charAt(i) - '0';
                num += tmp*tmp;
            }
            System.out.println(num);

            if (num == 1) return true;

            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
        }
    }

    public static void main(String[] args) {
        boolean res = isHappy(7);
        System.out.println(res);
    }
}
