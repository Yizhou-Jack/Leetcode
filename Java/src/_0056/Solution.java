package _0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /*
    先把数组排序。
    排序完毕之后比较每个int[]的right和后面的int[]的left大小，不停更新right。
    每个int[]比较完毕后将其放入需要返回的res。
    */

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        //根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });

        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //i不能到最后一行，所以要小于(数组的长度 - 1)
            //判断所在行的right和下一行的left大小，对right重新进行赋最大值，之后再不断进行while循环判断
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] input = new int[4][2];
        input[0] = new int[]{1,3};
        input[1] = new int[]{2,4};
        input[2] = new int[]{8,10};
        input[3] = new int[]{11,13};
        int[][] res = merge(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
