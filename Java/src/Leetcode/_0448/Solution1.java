package Leetcode._0448;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] counter = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]-1]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) res.add(i+1);
        }
        return res;
    }
}
