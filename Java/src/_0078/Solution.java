package _0078;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    /*
    回溯算法模板：和第46题相似，需要遍历所有的可能性
    */

    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new LinkedList<>());
        return res;
    }

    public static void backtrack(int i, int[] nums, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) {
            //做选择
            track.add(nums[j]);
            //进入下一层决策树
            backtrack(j + 1, nums, track);
            //取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == 0) {
                System.out.println("[]");
                continue;
            }
            String subRes = listToString(res.get(i),',');
            System.out.println(subRes);
        }
    }

    public static String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}
