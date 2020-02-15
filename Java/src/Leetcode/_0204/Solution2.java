package Leetcode._0204;

import java.util.Arrays;

public class Solution2 {

    /*
    Sieve of Eratosthenes (厄拉多塞筛法)
    */

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) { //小于sqrtN
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) { //大于i*i
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

}
