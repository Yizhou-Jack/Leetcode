package _0084;

public class Solution1 {

    /*
    递归方法：分治
    最大面积的矩形只有这三种情况：
    1. 确定了最矮的柱子之后，矩形的宽度尽可能向两边延伸
    2. 在最矮柱子的左边的最大面积的矩形（子问题）
    3. 在最矮柱子的右边的最大面积的矩形（子问题）
    子问题中，同样的，找最矮柱子的左右的最大面积矩形和确定最矮柱子之后延伸矩形的宽度
    */

    public static int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++)
            if (heights[minIndex] > heights[i])
                minIndex = i;
        int situationOne = heights[minIndex] * (end - start + 1);
        int situationOther = Math.max(calculateArea(heights, start, minIndex-1),
                                      calculateArea(heights, minIndex+1, end));
        return Math.max(situationOne, situationOther);
    }

    public static int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }
}
