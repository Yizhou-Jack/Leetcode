package Leetcode._0253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {

    /*
    按照开始时间给会议排序；
    构建一个最小堆，将第一个会议的结束时间添加到最小堆中，
    随后检查堆顶元素和接下来的会议的开始时间：
    1. 如果开始时间大于堆顶元素，那么将堆顶元素替换为接下来会议的结束时间
    2. else，那么扩展堆，将接下来会议的结束时间push入堆
    最后堆的大小即为需求会议室的个数
     */

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                });
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
                allocator.add(intervals[i][1]);
            } else {
                allocator.add(intervals[i][1]);
            }
        }

        return allocator.size();
    }
}
