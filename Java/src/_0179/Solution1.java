package _0179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            //compareTo方法
            //如果参数是一个按字典顺序排列等于该字符串的字符串，则返回值为0;
            //如果参数是按字典顺序大于此字符串的字符串，则返回值小于0;
            //如果参数是按字典顺序小于此字符串的字符串，则返回值大于0。
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        //转为str防止整型溢出
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        //用新的comparator排序
        Arrays.sort(asStrs, new LargerNumberComparator());

        if (asStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(asStrs[i]);
        }
        String res = sb.toString();

        return res;
    }

}
