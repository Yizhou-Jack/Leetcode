package Leetcode._0046;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    /*
    回溯算法模板：
    需要注意的是，回溯算法的时间复杂度很高（如果没有用动态规划的方法来优化）。
    但是这个问题本身就是要求出所有的组合，所以可以使用这个方法。
    */

    //提交到leetcode上时不能使用static，这样会使得后面的测试用例也使用第一个测试用例的res结果。
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    //路径：记录在 track 中
    //选择列表：nums中不存在于track的那些元素
    //结束条件：nums中的元素全都在track中出现
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) { //触发结束条件
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = permute(nums);
        for (int i = 0; i < res.size(); i++) {
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
