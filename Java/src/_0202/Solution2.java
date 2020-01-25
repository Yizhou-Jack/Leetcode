package _0202;

public class Solution2 {

    /*
    不快乐数最终都会进入如下数字循环序列： 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
    所以我们只要出现这些数字时直接终止循环即可
    */

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if((n == 4) || (n == 16) || (n == 37) || ( n == 58) || (n == 89) || (n == 145) || (n ==42) || (n == 20)) return false;
        int sum = 0;
        do {
            int remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        } while (n > 0);
        return isHappy(sum);
    }

}
