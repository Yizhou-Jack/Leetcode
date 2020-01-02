package _0011;

public class Solution {

    /*
    暴力求解：
    O(n^2)。利用两个for循环求获取到的最大面积：maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i))。
    */
    /*
    双指针法：
    将一个游标放在数列开头，一个游标放在数列末尾。
    每次计算完面积，短一点的线段（就是小一点的数字）一方游标向内移动一格距离。
    （首先向内移动距离的目的是为了找到更长的线段来弥补向内移动距离造成的宽度损失，如果把长一点的线段移动向内，
    那么由于受到短线段的限制，在宽度损失的同时必然无法增加长度，所以我们需要移动短线段的一方）
    */

    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,4,5,4,3,2};
        int maxArea = maxArea(intArray);
        System.out.println(maxArea);
    }

}
