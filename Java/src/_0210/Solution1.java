package _0210;

import java.util.*;

public class Solution1 {

    /*
    BFS解法：和第207题类似
    */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> edgeRes = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edgeRes.add(i);
        }
        if (prerequisites.length == 0) return convertIntegers(edgeRes);

        //保存每个节点的先修课个数，也就是出度
        HashMap<Integer, Integer> outNum = new HashMap<>();
        //保存以key为先修课的列表，也就是入度的节点
        HashMap<Integer, ArrayList<Integer>> inNodes = new HashMap<>();
        //保存所有节点
        HashSet<Integer> set = new HashSet<>();

        int rows = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            set.add(i);
            outNum.put(i, 0);
        }
        for (int i = 0; i < rows; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            set.add(key);
            set.add(value);
            if (!outNum.containsKey(key)) {
                outNum.put(key, 0);
            }
            if (!outNum.containsKey(value)) {
                outNum.put(value, 0);
            }
            //当前节点先修课个数加一
            int num = outNum.get(key);
            outNum.put(key, num + 1);

            if (!inNodes.containsKey(value)) {
                inNodes.put(value, new ArrayList<>());
            }
            //更新以value为先修课的列表
            ArrayList<Integer> list = inNodes.get(value);
            list.add(key);
        }

        List<Integer> res = new ArrayList<>();
        //将当前先修课个数为0的课加入到队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int k : set) {
            if (outNum.get(k) == 0) {
                queue.add(k);
                res.add(k);
            }
        }
        while (!queue.isEmpty()) {
            //队列拿出来的课，代表要删除的节点
            //要删除的节点的list中所有课的先修课个数减一
            int v = queue.remove();
            ArrayList<Integer> list = inNodes.getOrDefault(v, new ArrayList<>());

            for (int k : list) {
                int num = outNum.get(k);
                //当前课的先修课要变成0, 加入队列
                if (num == 1) {
                    queue.add(k);
                    res.add(k);
                }
                //当前课的先修课个数减一
                outNum.put(k, num - 1);
            }
        }

        //判断所有课的先修课的个数是否为0
        for (int k : set) {
            if (outNum.get(k) != 0) {
                return new int[]{};
            }
        }

        return convertIntegers(res);
    }

    public static int[] convertIntegers(List<Integer> integers){
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
}
