package Leetcode._0771;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static int numJewelsInStones(String J, String S) {
        if (J.equals("") || S.equals("")) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = numJewelsInStones("aA", "aAAbbbb");
        System.out.println(res);
    }
}
