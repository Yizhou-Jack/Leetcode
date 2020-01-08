package _0042;

public class Solution1 {

    /*
    此方法时间复杂度为O(n^2)。
    对于每一列，向左向右扫描最高的墙的高度，如果两墙之间较矮的墙比这列要高，那么这列就有水（min两墙-这列的高度）
    */

    public static int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        //最两端的列不用考虑，所以下标从1到length-2
        for (int i = 1; i < len - 1; i++) {
            //找出左边最高
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            //找出右边最高
            int maxRight = 0;
            for (int j = i + 1; j < len; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{3,4,1,9,5,2,1,7,19,20};
        int res = trap(heights);
        System.out.println(res);
    }
}
