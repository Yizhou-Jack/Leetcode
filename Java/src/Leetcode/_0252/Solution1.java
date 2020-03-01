package Leetcode._0252;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}
