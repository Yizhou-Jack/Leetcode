package Leetcode._0039;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<Integer>> res =  new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, track);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, LinkedList<Integer> track) {
        if (target < 0) return;
        if (target == 0){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if (target < candidates[i]) break;
            track.add(candidates[i]);
            backtrack(candidates, i,target-candidates[i], track);
            track.removeLast();
        }
    }

}
