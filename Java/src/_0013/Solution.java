package _0013;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    构造hashmap，根据罗马数字转换为数字的性质，首先检查index之后两位字母是否为特殊情况，若不是再检查index之后一位字母的大小，
    将map中get到的数字累加即为结果。
    */

    public static int romanToInt(String s) {
        int x = 0;
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int index = 0;
        int len = s.length();
        while (index < len - 1){
            String ss = s.substring(index,index + 2);
            if (map.containsKey(ss)){
                x += map.get(ss);
                index += 2;
            }
            else{
                String str = s.substring(index, index + 1);
                x += map.get(str);
                index++;
            }
        }
        if (index < len){
            String str = s.substring(index, index + 1);
            x += map.get(str);
        }
        return x;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int num = romanToInt(s);
        System.out.println(num);
    }

}
