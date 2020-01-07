package _0038;

public class Solution {

    /*
    利用subRes固定住tmp.charAt(j)的值。
    在下一位不是与前面相同的char时，累加phase。
    */

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String phase = "1";
        for (int i = 0; i < n-1; i++) { //n-1意为去掉n==1的情况
            String tmp = phase;
            int len = tmp.length();
            StringBuilder builder = new StringBuilder(); //用StringBuilder创建string可以加速（而非使用字符串拼接）

            int num = 0;
            int j = 0;
            while (j < len) {
                char subRes = tmp.charAt(j);
                while (j < len){
                    if (tmp.charAt(j) == subRes) {
                        num++;
                        j++;
                    } else {
                        break;
                    }
                }
                builder.append(num).append(subRes);
                num = 0;
            }
            phase = builder.toString();
            //System.out.println("phase:"+phase);
            //System.out.println("j:"+j);
        }
        return phase;
    }

    public static void main(String[] args) {
        String res = countAndSay(5);
        System.out.println(res);
    }
}
