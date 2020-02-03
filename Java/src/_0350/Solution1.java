package _0350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution1 {

    /*
    先将两个数组进行排序，然后用双指针法
    */

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return convertIntegers(res);
    }

    public static int[] convertIntegers(List<Integer> integers){
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
}
