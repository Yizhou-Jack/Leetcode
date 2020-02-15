package Leetcode._0139;

import java.util.*;

public class Solution {

    /*
    BFS算法：（利用queue实现）
    把字符串的第一个字符当作根部，for循环找后面部分的字符串的子字符串是否可行，
    找到即标记起始index为已经找过的index，并将结束index入队列
    */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()]; //GSA的算法，经过的点就不再次经过
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        if (end == s.length()) {
                            return true;
                        }
                        queue.add(end);
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
