package Leetcode._0191;

public class Solution1 {

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) { //&是按位与，都是1结果位上才是1，否则为0
                bits++;
            }
            mask <<= 1; //二进制位向左移动一位 = *2
        }
        return bits;
    }

}
