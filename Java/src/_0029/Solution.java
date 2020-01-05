package _0029;

public class Solution {

    public static int divide(int dividend, int divisor) {
        int res = 0;
        if (dividend == 0){
            return 0;
        }
        if (divisor > 0 && dividend > 0){
            while (dividend >= 0){
                dividend -= divisor;
                res += 1;
            }
            res = res-1;
        }
        else if (divisor < 0 && dividend > 0){
            while (dividend >= 0){
                dividend += divisor;
                res += 1;
            }
            res = -(res-1);
        }
        else if (divisor > 0 && dividend < 0){
            while (dividend <= 0){
                dividend += divisor;
                res += 1;
            }
            res = -(res-1);
        }
        else if (divisor < 0 && dividend < 0){
            while (dividend <= 0){
                dividend -= divisor;
                res += 1;
            }
            res = res-1;
        }
        return res;
    }
}
