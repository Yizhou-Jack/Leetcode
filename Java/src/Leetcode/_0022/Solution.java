package Leetcode._0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    递归方法：
    左括号个数必须大于右括号的放置个数，才能继续放右括号；
    左括号的个数小于n，才能继续放左括号；
    到达叶子节点后，左括号和右括号满足上述条件的前提下都为n个，添加这个答案。
    */

    private static void generate(String item, int left, int right, List res){
        //左括号和右括号满足上述条件的前提下都为n个，添加这个答案（递归到达叶节点）
        if (left == 0 && right == 0){
            res.add(item);
            return;
        }
        //左括号的个数小于n，才能继续放左括号
        if (left > 0){
            generate(item + "(",left-1, right, res);
        }
        //左括号个数必须大于右括号的放置个数，才能继续放右括号
        if (left < right){
            generate(item + ")", left,right-1, res);
        }
    }

    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(4);
        System.out.println(res);
    }
}
