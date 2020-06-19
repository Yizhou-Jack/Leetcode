package Leetcode._0040;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<Integer>> res =  new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, track);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, LinkedList<Integer> track) {
        if (target < 0) return;
        if (target == 0){
            if (!res.contains(track)) res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            track.add(candidates[i]);
            backtrack(candidates, i+1, target-candidates[i], track);
            track.removeLast();
        }
    }

}
