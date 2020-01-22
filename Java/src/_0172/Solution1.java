package _0172;

public class Solution1 {

    /*
    数学规律解题：
    对于每个阶乘，只需要知道每个数字有多少个5的因数就可以了（因为2的因数必定大于5的因数）
    同时：每隔5个数，出现一个5的因数；每隔25个数，出现两个5的因数（25=5*5）；每隔125个数，出现三个5的因数（125=5*5*5）
    */

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
