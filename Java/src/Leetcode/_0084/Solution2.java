package Leetcode._0084;

import java.util.Stack;

public class Solution2 {

    /*
    栈方法：
    求最大的矩形面积可以如此：对于一个柱子来说，找到它左边柱子们从右向左数的第一个比它短的柱子，再找到它右边柱子们从左向右数的第一个比它短的柱子，
                         就可以求出矩形的面积为 (rightLessMin - leftLessMin - 1) * 当前柱子高度，
                         遍历每个柱子，按同样的方法算出每个柱子的最大矩形，取最大值。
    用栈是这个思路：遍历每个柱子，分为以下三种情况：
                 1. 如果当前栈空，或者当前柱子的高度大于栈顶柱子的高度，那么将当前柱子的下标入栈
                 2. 如果当前柱子的高度小于栈顶柱子的高度，那么将栈顶柱子出栈。栈顶柱子就是上面描述的最大矩形面积求法中遍历到要求面积的柱子，
                    上面描述的最大矩形面积求法中右边柱子们从左向右数的第一个比它短的柱子，就是目前这个方法遍历到的柱子，
                    上面描述的最大矩形面积求法中左边柱子们从右向左数的第一个比它短的柱子，就是新的栈顶柱子
                 3. 遍历完成后，如果栈没有空，那么将栈内元素一词出栈，出栈元素当作上面描述的最大矩形面积求法中遍历到要求面积的柱子
    */

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < heights.length) {
            //栈空入栈
            if (stack.isEmpty()) {
                stack.push(index);
                index++;
            } else {
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if (heights[index] >= heights[top]) {
                    stack.push(index);
                    index++;
                } else {
                    //保存栈顶高度
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = index;
                    //计算面积
                    int area = (RightLessMin - leftLessMin - 1) * height;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        while (!stack.isEmpty()) {
            //保存栈顶高度
            int height = heights[stack.pop()];
            //左边第一个小于当前柱子的下标
            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
            int RightLessMin = heights.length;
            int area = (RightLessMin - leftLessMin - 1) * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }
}
