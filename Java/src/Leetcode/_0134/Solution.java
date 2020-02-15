package Leetcode._0134;

public class Solution {

    /*
    遍历一遍的解法：
    如果所有的gas累加小于所有的cost累加，那么肯定不能到达目的地。所以要检查所有gas-所有cost的结果是否大于0.
    从0点出发，如果当前汽油大于等于0，那么起始点不变，累加当前汽油值；
             如果当前汽油小于0，那么起始点变成遍历到的点。
    ***所有的gas累加大于所有的cost累加，可证从更新到的start出发，一定能回到start***
    */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int start = 0;

        for (int i = 0; i < len; i++) {
            totalTank += gas[i]-cost[i];
            if (curTank >= 0) {
                curTank += gas[i]-cost[i];
            } else {
                curTank = gas[i]-cost[i];
                start = i;
            }
        }

        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,4,5,1,2,8,4};
        int res = canCompleteCircuit(nums, nums);
        System.out.println(res);
    }
}
