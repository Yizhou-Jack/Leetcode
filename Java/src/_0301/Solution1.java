package _0301;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<String> res = new LinkedList<>();

    public List<String> removeInvalidParentheses(String s) {
        backtrack(0, s, new LinkedList<>());
        return res;
    }

    public void backtrack(int i, String s, LinkedList<String> track) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < s.length; j++) { //循环开启的位置不一定相同：参见46/78
            //做选择
            track.add(s);
            //进入下一层决策树
            backtrack(j + 1, s, track);
            //取消选择
            track.removeLast();
        }
    }
}
