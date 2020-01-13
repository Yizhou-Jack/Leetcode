package _0088;

public class Solution {

    /*
    双指针法，但是因为是merge，而且nums1有额外的空间，因此可以从后向前add。
    最后如果nums2还有额外的元素还没加进去，直接将剩余元素复制进nums1。
    */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1; //向nums1中写元素的指针

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            } else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
            //更简便的写法：nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        //最后如果nums2还有额外的元素还没加进去，直接将剩余元素复制进nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
