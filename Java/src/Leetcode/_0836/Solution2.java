package Leetcode._0836;

public class Solution2 {

    /*
    假设交点区域是 width * height，其中 width 是交点区域在 x 轴上的投影，height 是在 y 轴上的投影。我们希望这两个量都是正数
     */

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }
}
