package _0127;

import javafx.util.Pair;

import java.util.*;

public class Solution2 {

    /*
    双向BFS：利用两个queue实现
    问题可以抽象成一个无向无权图，每个单词是一个节点，差距只有一个字母的两个节点之间连一条边。问题转化为找到从起点到终点的最短路径。
    因此可以使用BFS解决问题，更有效率的方法是使用双向BFS。
    一个queue从beginWord开始找，一个queue从endWord开始找，在循环中判断哪个queue的size更小，永远只出小一点的队列。
    */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int len = beginWord.length(); //题设为所有的字符串都是同样的长度

        //map的意义：key：通用状态，value：有此通用状态的单词list
        //构建全通用状态对应全单词的map
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < len; j++) {
                String commonState = word.substring(0, j) + '*' + word.substring(j + 1, len);
                ArrayList<String> trans = map.getOrDefault(commonState, new ArrayList<>());
                trans.add(word);
                map.put(commonState, trans);
            }
        }

        //利用两个queue实现双向BFS算法
        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
        beginQueue.add(new Pair(beginWord, 1));
        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
        endQueue.add(new Pair(endWord, 1));

        //visited map保证不走回头路
        HashMap<String, Integer> visited = new HashMap<>();
        HashMap<String, Integer> otherVisited = new HashMap<>();
        visited.put(beginWord, 1);
        otherVisited.put(endWord, 1);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            //核心：控制当前循环从哪个方向进行bfs; 让beginQueue指向size更小的集合, 这样就不会一直从一个方向bfs了
            if (beginQueue.size() > endQueue.size()) {
                Queue<Pair<String, Integer>> tmp = beginQueue;
                beginQueue = endQueue;
                endQueue = tmp;
                HashMap<String, Integer> tmp2 = visited;
                visited = otherVisited;
                otherVisited = tmp2;
            }
            Pair<String, Integer> node = beginQueue.remove(); //FIFO，先进的先退出队列
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                String commonState = word.substring(0,i) + '*' + word.substring(i+1,len);
                ArrayList<String> words = map.getOrDefault(commonState, new ArrayList<>()); //找到通用状态对应的所有单词
                for (int j = 0; j < words.size(); j++) {
                    String adjacentWord = words.get(j); //该通用状态对应的单词列表，都是上个单词的连接单词
                    if (otherVisited.containsKey(adjacentWord)) return level+otherVisited.get(adjacentWord);
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, level+1);
                        beginQueue.add(new Pair(adjacentWord, level+1)); //如果之前没有找到过这个单词，那么将其入队列（GSA）
                    }
                }
            }
        }
        return 0;
    }

}
