package Leetcode._0642;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode-cn.com/problems/design-search-autocomplete-system/solution/javaqian-zhui-shu-you-xian-dui-lie-by-zhong-wu-qi/
1. 前缀树为27叉树，每个节点的子节点记录在长度为27的数组中。0-25对应a-z（index = char - 'a'）。26对应空格。
2. 如果节点为句子终结节点，其中的属性sentence会记录整个句子（方便自动补全时返回结果），times会记录相应热度（之前搜索的次数）。
3. 由于在搜索过程中，每次只会输入一个字符，所以前缀树对象中包含一个当前节点对象current，作为之前搜索到的节点。current被初始化为root。每次新来一个字符，该属性都会更改为输入字符对应的子节点。如果遇到终结符#，current重置为root。
4. 每次搜索以当前已输入部分作为前缀的句子时，会把当前节点作为参数调用递归函数searchSentence。其返回值保存在pq这一优先队列中。该优先队列存放的是树节点，通过自定义比较函数比较节点的排名（先比较times，相等则比较sentence）。当优先队列存放元素超过3个时，弹出顶部的元素，也就是排名最靠后的节点。所以最多返回3个排名最靠前的节点对应的句子。
 */

class AutocompleteSystem {

    private Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        int n = sentences.length;
        for (int i = 0; i < n; ++i) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        return trie.searchChar(c);
    }
}

class Trie {
    private TrieNode root;
    private TrieNode current;           // 在插入过程中的当前节点，一句话插完后重置为root
    private PriorityQueue<TrieNode> pq; // 小顶堆，自定义比较函数，用来保存排在前3的句子
    private StringBuilder sb;           // 单个字符输入时，保存已输入字符

    public Trie() {
        root = new TrieNode();
        current = root;
        Comparator<TrieNode> comparator = new Comparator<TrieNode>() {
            public int compare(TrieNode node1, TrieNode node2) {
                if (node1.times != node2.times) {
                    return node1.times - node2.times;
                }
                return node2.sentence.compareTo(node1.sentence); //比较ASCII码
            }
        };
        pq = new PriorityQueue(4, comparator);
        sb = new StringBuilder();
    }

    public void insert(String sentence, int times) {
        int n = sentence.length();
        for (int i = 0; i < n; ++i) {
            insertNewChar(sentence.charAt(i));
        }
        current.sentence = sentence; //只有最后的node才有sentence和times（句末才保存）
        current.times += times;
        current = root; //插入完一个字符串之后回到root
    }

    // 插入新字符，并更新current
    // 之前前缀没有该字符，返回true
    private boolean insertNewChar(char c) {
        int charNo = c == ' ' ? 26 : c - 'a';
        if (current.children[charNo] != null) {
            current = current.children[charNo];
            return false;
        }
        current.children[charNo] = new TrieNode();
        current = current.children[charNo];
        return true;
    }

    // 在当前节点中搜索字符，如果为终止符，则结束该句搜索过程
    // 否则，如果插入字符之前没有该前缀，则返回空列表
    // 否则，从该字符所在的点开始，搜索所有句子，并找出其中3个最大的
    public List<String> searchChar(char c) {
        List<String> result = new LinkedList<>();
        if (c == '#') {
            current.sentence = sb.toString();
            ++current.times;
            current = root;
            sb.delete(0, sb.length()); //清空sb
            return result;
        }

        sb.append(c);

        if (insertNewChar(c)) return result; //没有找到前缀，直接返回空list（此时更新curr的值）

        searchSentence(current);
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().sentence);
        }

        return result;
    }

    // 从node点开始向下寻找句子，保存在优先队列里，超过3个弹出
    private void searchSentence(TrieNode node) {
        if (node.sentence != null) {
            pq.offer(node);
            if (pq.size() > 3)
                pq.poll();
        }
        for (TrieNode child: node.children) {
            if (child != null) searchSentence(child);
        }
    }
}

class TrieNode {
    public TrieNode[] children;
    public String sentence;     // 如果该点为句子终点，保存整个句子
    public int times;           // 如果该点为句子终点，记录句子热度

    public TrieNode() {
        times = 0;
        children = new TrieNode[27];
        sentence = null;
    }
}

