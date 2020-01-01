package _0007;

public class Solution {

    /*
    数学方法：
    将x除以10后的余乘10，循环操作；每次都判断产生的值是否超过integer的最大值或者小于integer的最小值。
    */

    public static int reverse(int x) {
        long temp = 0;
        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;
    }

    /*
    字符串反转方法：
    把int转换为string，反转字符串并检查是否超值。
    */
    /*
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;//因为该数的绝对值越界了，而且其翻转的结果超过了int范围，这里直接处理
        boolean mark = true;//该标记位用来记录x是正数还是负数
        if (x<0) {//如果x是负数，则改变标记位，同时将负数变成正数
            mark = false;
            x = Math.abs(x);
        }
        String str = Integer.toString(x);//正数变成字符串String
        StringBuffer stringBuffer = new StringBuffer(str);//字符串String变成StringBuffer
        str = stringBuffer.reverse().toString();//StringBuffer翻转在变回字符串String
        long result = Long.parseLong(str);//字符串变成长整型，这里为什么用长整型来接收，是因为有很多数已经越界了
        if (mark == false) {//如果标记位为负数，则转回负数
            result = 0 - result;
        }
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {//如果翻转后的数字超过int类型范围，则返回0
            return 0;
        }
        return (int) result;
    }
    */

    public static void main(String[] args) {
        int reverseInt = reverse(1252153219);
        System.out.println(reverseInt);
    }
}
