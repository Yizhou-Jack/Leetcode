package Leetcode._0229;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            if (num == candidateA) { //当前值和A相等
                countA++;
                continue;
            }
            if (num == candidateB) { //当前值和B相等
                countB++;
                continue;
            }
            if (countA == 0) { //A的数量为0，更新A
                candidateA = num;
                countA = 1;
                continue;
            }
            if (countB == 0) { //B的数量为0，更新B
                candidateB = num;
                countB = 1;
                continue;
            }
            //不是A也不是B，A和B的数量都不是0，那么两个候选人的票数都-1
            countA--;
            countB--;
        }

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) countA++;
            else if (num == candidateB) countB++;
        }
        if (countA > nums.length/3) res.add(candidateA);
        if (countB > nums.length/3) res.add(candidateB);
        return res;
    }
}
