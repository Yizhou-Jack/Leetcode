package Leetcode._0017;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    递归树求解
    */
    //一个映射表，第二个位置是"abc“,第三个位置是"def"...
    private String[] letterMap = {
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.equals("")) return res; //判断特殊情况

        findCombination(digits, 0, "");
        return res;
    }

    void findCombination(String digits, int index, String letter){
        if(index == digits.length()){
            res.add(letter);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '2']; //去掉0，1
        for(int i = 0 ; i < letters.length() ; i++){
            findCombination(digits, index+1, letter + letters.charAt(i));
        }
    }
}