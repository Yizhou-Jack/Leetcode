package _0621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    /*
    需要把任务数量最多的任务放在最先处理，不然在后面会出现等待，所以需要PriorityQueue。
    用一个tmp List来储存在n+1时间内已经执行过的任务
    */

    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c-'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int count : counts) {
            if (count > 0) queue.add(count);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> tmp = new ArrayList<>(); //用于储存在n+1时间内已经执行过的任务
            while (i <= n) { //冷却时间为n
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        tmp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                res++;
                if (queue.isEmpty() && tmp.size() == 0) break; //所有的任务都已经执行完了
                i++;
            }
            for (int task: tmp) { //把执行过的task加回queue
                queue.add(task);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[] charArr = new char[]{'A','A','A','B','B','B'};
        int res = leastInterval(charArr, 2);
        System.out.println(res);
    }
}
