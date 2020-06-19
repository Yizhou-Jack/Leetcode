package Interview.microsoft;

import java.util.*;

import javafx.util.Pair;

public class Question1 {

    public static int solution(char[] chars) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(chars.length, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        String init = String.valueOf(chars);
        map.put(init, 0);
        pq.add(new Pair<>(init, 0));
        while (!pq.isEmpty()) {
            Pair<String, Integer> popPair = pq.poll();
            String popString = popPair.getKey();
            Integer step = popPair.getValue();
            int[] parPair = checkPar(popString.toCharArray());
            if (parPair[0] != 0 || parPair[1] != 0) {
                String str = popString.substring(0, parPair[0]) + popString.substring(parPair[1]+1);
                int strStep = map.getOrDefault(str, Integer.MAX_VALUE);
                if (strStep > step+1) {
                    map.put(str, step+1);
                    pq.add(new Pair<>(str, step+1));
                }
            }
            for (int i = 0; i < popString.length(); i++) {
                String str = popString.substring(0, i) + popString.substring(i+1);
                int strStep = map.getOrDefault(str, Integer.MAX_VALUE);
                if (strStep > step+1) {
                    map.put(str, step+1);
                    pq.add(new Pair<>(str, step+1));
                }
            }
        }
        return map.getOrDefault("", -1);
    }

    public static int[] checkPar(char[] chars) {
        boolean[][] dp = new boolean[chars.length][chars.length];
        int maxLen = 0;
        int[] res = new int[2];
        for (int len = 1; len < chars.length; len++) {
            for (int i = 0; i < chars.length; i++) {
                if (i+len >= chars.length) break;
                if (len == 1 || len == 2) {
                    dp[i][i+len] = chars[i] == chars[i+len];
                } else {
                    dp[i][i+len] = chars[i] == chars[i+len] && dp[i+1][i+len-1];
                }
                if (dp[i][i+len] && maxLen < len) {
                    res[0] = i;
                    res[1] = i+len;
                    maxLen = len;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] strList = sc.nextLine().toCharArray();
        System.out.println("solution:"+solution(strList));
    }

}
