package Leetcode._1239;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int res = 0;

    public int maxLength(List<String> arr) {
        List<String> newArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);
            int[] intArr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                if (intArr[str.charAt(j)-'a'] == 0) {
                    intArr[str.charAt(j)-'a'] = 1;
                } else {
                    break;
                }
                if (j == str.length()-1) newArr.add(str);
            }
        }
        backtrack(0, newArr, new int[26]);
        return res;
    }

    public void backtrack(int i, List<String> nums, int[] track) {
        for (int j = i; j < nums.size(); j++) {
            //做选择
            boolean flag = false;
            String str = nums.get(j);
            for (int k = 0; k < str.length(); k++) {
                if (track[str.charAt(k)-'a'] != 0) flag = true;
            }
            if (!flag) {
                for (int k = 0; k < str.length(); k++) {
                    track[str.charAt(k)-'a'] = 1;
                }
                int count = 0;
                for (int k = 0; k < track.length; k++) {
                    if (track[k] == 1) count++;
                }
                res = Math.max(res, count);
            }
            //进入下一层决策树
            backtrack(j + 1, nums, track);
            //取消选择
            if (!flag) {
                for (int k = 0; k < str.length(); k++) {
                    track[str.charAt(k)-'a'] = 0;
                }
            }
        }
    }
}
