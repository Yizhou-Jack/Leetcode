package Leetcode._0018;

import java.util.*;

public class Solution1 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res =new ArrayList<>();
        if (nums == null || nums.length < 4) return res;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            //检查最小值是否大于target
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) break;
            //检查最大值是否小于target
            if (nums[i]+nums[len-1]+nums[len-2]+nums[len-3] < target) continue;

            for (int k = i+1; k < len-2; k++) {
                if (k > i+1 && nums[k] == nums[k-1]) continue;
                int j = k+1;
                int h = len-1;
                if (nums[i]+nums[k]+nums[j]+nums[j+1] > target) continue;
                if (nums[i]+nums[k]+nums[h]+nums[h-1] < target) continue;
                while (j < h) {
                    int curr = nums[i]+nums[k]+nums[j]+nums[h];
                    if (curr == target) {
                        res.add(Arrays.asList(nums[i], nums[k], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j-1]) {
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h+1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,2,1,0,-1,0,-2,2};
        List<List<Integer>> res = fourSum(nums, 0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

}
