package Leetcode._0077;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i+1;
        backtrack(0, nums, new LinkedList<>(), k);
        return res;
    }

    public void backtrack(int i, int[] nums, LinkedList<Integer> track, int k) {
        if (track.size() == k) res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) {
            //做选择
            track.add(nums[j]);
            //进入下一层决策树
            backtrack(j + 1, nums, track, k);
            //取消选择
            track.removeLast();
        }
    }
}
