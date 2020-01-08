package _0042;

public class Solution2 {

    /*
    动态规划方法：
    在Solution1中，每列都要向左向右扫描获取向左向右的墙的最高高度。
    其实在向左扫描时，只要比较：
    1. 左边的墙在向左扫描时获取到的最高墙的值，2. 左边的墙的高度
    右边的墙同理。比较1和2就可以获得向左向右的墙的最高高度，避免了重复扫描。
    */

    public static int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        //指针从1指到len-2
        for (int i = 1; i < len-1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for (int i = len-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for (int i = 1; i < len-1; i++) {
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            int min = Math.min(maxLeft[i], maxRight[i]);
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
