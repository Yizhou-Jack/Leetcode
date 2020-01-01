package _0008;

public class Solution {

    public static int myAtoi(String str) {
        //判断长度为0与值为null的情况
        if (str == null) return 0;
        str = str.trim(); //删除字符串头尾的空格
        if (str.length() == 0) return 0;

        //判断正负性
        int i = 0;
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }

        //找出数字部分
        int res = 0;
        for (; i < str.length(); i++) { //使用；--> i为先前计算出的值
            ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                break; //第一个非空字符不是数字
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10)
                return Integer.MAX_VALUE;
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) //'9'-'0'的值为int 9
                return Integer.MAX_VALUE;
            if (flag < 0 && -res < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + (ch - '0');
        }
        return res * flag;
    }

    public static void main(String[] args) {
        int atoi = myAtoi("1252153219");
        System.out.println(atoi);
    }
}
