package Interview.alibaba;

import java.util.*;

public class Question1 {

    public static int solution(int n) {
        long res = 0;
        for (int i = 1; i < n+1; i++) {
            int subres = 1;
            for (int j = n; j > n-i; j--) {
                subres *= j;
            }
            for (int j = 1; j < i+1; j++) {
                subres /= j;
            }
            subres *= i;
            res += subres;
        }
        return (int)res%(1000000000+7);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int res = solution(n);
            System.out.println(res);
        }
    }
}
