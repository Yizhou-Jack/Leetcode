package Leetcode._0217;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{3,2,3,1,2,4,5,5,6};
        boolean res = containsDuplicate(intArr);
        System.out.println(res);
    }

}
