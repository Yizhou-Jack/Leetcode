package Leetcode._0190;

public class Solution1 {

    public int reverseBits(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res <<= 1;  //res左移一位空出位置（空的位置补上了0）
            res |= (n & 1); //得到的最低位加过来（&是按位与，都是1结果位上才是1）；（|：两个二进制对应位为0时该位为0，否则为1）
            n >>= 1;//原数字右移一位去掉已经处理过的最低位
            count++;
        }
        return res;
    }

}
