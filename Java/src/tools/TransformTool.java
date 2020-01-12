package tools;

import java.util.Arrays;
import java.util.List;

public class TransformTool {

    /*
    int[]转为String
    */
    public static String IntArrToString(int[] intArr) {
        return Arrays.toString(intArr);
    }

    /*
    数字char转为int
    */
    public static int NumCharToInt(char numChar) {
        return numChar - '0';
    }

    /*
    String[]转为int[]
    */
    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    /*
    List<int[]>转为int[][]
    */
    public static int[][] ListIntArrToIntArrArr(List<int[]> input) {
        return input.toArray(new int[0][]);
    }

    /*
    List转为string
    */
    public String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator); //List中用get来获取index i上的数字
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }

}
