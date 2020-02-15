package tools;

import java.util.*;

public class CommonTool {

    /*
    获取字母位数的sum
     */
    public int getNumBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /*
    复制int[]
    */
    public static int[] copyIntArr(int[] intArr) {
        int[] res = intArr.clone();
        return res;
    }

    /*
    map中的值升序排列和降序排列
    */
    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return compare; //升序排列 //降序排列则是-compare
            }
        });
        Map<Integer, Integer> returnMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }

    /*
    获取int[]中的max值
    */
    public static int MAX(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    /*
    判断char是否为字母或者是数字
    */
    public boolean isLetterOrDigit (char c) {
        boolean res1 = Character.isLetterOrDigit(c);
        boolean res2 = Character.isLetter(c); //判断char是否为字母
        boolean res3 = Character.isDigit(c); //判断char是否为数字
        return res1;
    }

    /*
    将char改为小写
    */
    public char charToLowerCase (char c) {
        char res = Character.toLowerCase(c);
        return res;
    }

    /*
    检查字符内的回文串（动态规划方法）
    */
    public boolean[][] checkHuiWen(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        return dp;
    }
}
