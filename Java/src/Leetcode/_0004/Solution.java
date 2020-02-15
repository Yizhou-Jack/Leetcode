package Leetcode._0004;

public class Solution {

    /*
    题目要求时间复杂度为O(log(m+n))，那么需要用二分法的方法来处理。
    由于两个数列都是有序的，我们要找第k小的数。用此办法，每次divide都可以排除掉k/2个数：
    比如要找第7小的数，7/2向下取整为3。那么我们比较nums1中第三个数与num2中第三个数，哪个数列小就把哪个数列前面的三个数字排除。
    1. num1和num2都有大于k/2个数：使用上述方法
    2. num1和num2中有个数列小于k/2：指向末尾
    3. num1和num2中有个数列被删完了：直接返回剩下那个数列的目标值
    */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的k
        //（n+m为奇数时，取median取得是left位置上的值 or right位置上的值；n+m为偶数时，取median取得是(left+right)位置上的值/2）
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让len1的长度小于len2，这样就能保证如果有数组空了，一定是len1（return的function更换了nums1和num2的位置）
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1]; //上述第三种情况：某一个数列已被删除完

        if (k == 1) return Math.min(nums1[start1], nums2[start2]); //当k为1时，返回两个数列的start的最小值（divide的叶子结点）

        //取两数的min的原因为上述第二种情况：数列长度不够时指向数列的末尾
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        //上述第一种情况。比较完之后要移动start1 or start2的位置，还要将k减去start移动的距离
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2,3,4,5};
        int[] num2 = new int[]{1,2,3,4};
        double targetDouble = findMedianSortedArrays(num1, num2);
        System.out.println(targetDouble);
    }
}
