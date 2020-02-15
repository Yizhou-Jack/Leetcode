package Leetcode._0076;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    双指针-滑动窗口法找最小覆盖字串：
    先移动right，移动到找到覆盖字串，随后移动left至最短的满足覆盖字串条件的字符串；
    随后再移动right至重新符合条件，直到right移动到末尾。
    */

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        //用map储存t中各字符的出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count+1);
        }

        int charNum = map.size(); //map中有几种类型的字符
        int present = 0; //记录出现过几种类型的字符
        int left = 0;
        int right = 0;
        Map<Character, Integer> windowMap = new HashMap<>(); //记录滑动窗口中出现字符的次数

        int[] resArr = new int[]{-1, left, right};
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = windowMap.getOrDefault(c, 0);
            windowMap.put(c, count+1);
            //某个字符出现次数齐全
            if (map.containsKey(c) && windowMap.get(c).intValue() == map.get(c).intValue()) {
                present++;
            }
            //如果满足了left到right这个区间满足了条件，缩减left直到不满足条件
            while (left <= right && present == charNum) {
                c = s.charAt(left);
                //在resArr中保存目前为止最小的滑动窗口
                if (resArr[0] == -1 || right-left+1 < resArr[0]) {
                    resArr[0] = right-left+1;
                    resArr[1] = left;
                    resArr[2] = right;
                }
                //在left向左移动后，windowMap中的count也要相应减少
                windowMap.put(c, windowMap.get(c)-1);
                //left缩小至条件不满足后，present需要减少，并且可以跳出循环
                if (map.containsKey(c) && windowMap.get(c).intValue() < map.get(c).intValue()) {
                    present--;
                }
                left++;
            }
            right++;
        }
        return resArr[0] == -1 ? "" : s.substring(resArr[1], resArr[2] + 1);
    }
}
