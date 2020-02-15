package Leetcode._0128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
    哈希set解法
    尽管在for循环中嵌套了一个while循环，时间复杂度看起来像是二次方级别的。但其实它是线性的算法。
    因为只有当currentNum遇到了一个序列的开始，while循环才会被执行（不是每次for都会执行while）
    */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longestCnt = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curCnt = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curCnt++;
                }
                longestCnt = Math.max(longestCnt,curCnt);
            }
        }
        return longestCnt;
    }
}
