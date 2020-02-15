package Leetcode._1309;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static String freqAlphabets(String s) {
        Map<Character, Character> map1 = new HashMap<>();
        map1.put('1','a');
        map1.put('2','b');
        map1.put('3','c');
        map1.put('4','d');
        map1.put('5','e');
        map1.put('6','f');
        map1.put('7','g');
        map1.put('8','h');
        map1.put('9','i');
        Map<String, Character> map2 = new HashMap<>();
        map2.put("10#",'j');
        map2.put("11#",'k');
        map2.put("12#",'l');
        map2.put("13#",'m');
        map2.put("14#",'n');
        map2.put("15#",'o');
        map2.put("16#",'p');
        map2.put("17#",'q');
        map2.put("18#",'r');
        map2.put("19#",'s');
        map2.put("20#",'t');
        map2.put("21#",'u');
        map2.put("22#",'v');
        map2.put("23#",'w');
        map2.put("24#",'x');
        map2.put("25#",'y');
        map2.put("26#",'z');

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            if (i + 2 < len && s.charAt(i+2) == '#') {
                sb.append(map2.get(s.substring(i, i+3)));
                i += 3;
            } else {
                sb.append(map1.get(s.charAt(i)));
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String res = freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        System.out.println(res);
    }
}
