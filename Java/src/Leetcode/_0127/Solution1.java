package Leetcode._0127;

import javafx.util.Pair;

import java.util.*;

public class Solution1 {

    /*
    单向BFS：利用queue实现
    问题可以抽象成一个无向无权图，每个单词是一个节点，差距只有一个字母的两个节点之间连一条边。问题转化为找到从起点到终点的最短路径。
    因此可以使用BFS解决问题。
    首先构建一个map：key是一个单词通用状态，value是有此通用状态的单词的list。
    */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length(); //题设为所有的字符串都是同样的长度

        //map的意义：key：通用状态，value：有此通用状态的单词list
        //构建全通用状态对应全单词的map
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < len; j++) {
                String commonState = word.substring(0,j) + '*' + word.substring(j+1,len);
                ArrayList<String> trans = map.getOrDefault(commonState, new ArrayList<>());
                trans.add(word);
                map.put(commonState, trans);
            }
        }

        //利用queue实现BFS算法
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        //一个visited map保证不走回头路
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove(); //FIFO，先进的先退出队列
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String commonState = word.substring(0,i) + '*' + word.substring(i+1,len);
                ArrayList<String> words = map.getOrDefault(commonState, new ArrayList<>()); //找到通用状态对应的所有单词
                for (int j = 0; j < words.size(); j++) {
                    String adjacentWord = words.get(j); //该通用状态对应的单词列表，都是上个单词的连接单词
                    if (adjacentWord.equals(endWord)) return level+1;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level+1)); //如果之前没有找到过这个单词，那么将其入队列（GSA）
                    }
                }
            }
        }
        return 0;
    }

}
