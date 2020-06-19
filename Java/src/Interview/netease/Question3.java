package Interview.netease;

import java.util.*;

public class Question3 {

    public static int solution(int[] ablity, int[] damage, int D){
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        String init = "";
        for (int i = 0; i < ablity.length; i++) {
            init += "1";
        }
        queue.add(init);
        map.put(init, 0);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            int minDamage = map.get(str);
            int protect = D;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') protect++;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    StringBuffer sb = new StringBuffer(str);
                    String newStr = sb.substring(0,i) + "0" + sb.substring(i+1);
                    int dam = map.getOrDefault(newStr, Integer.MAX_VALUE);
                    if (ablity[i] >= protect) {
                        map.put(newStr, Math.min(minDamage+damage[i], dam));
                    } else {
                        map.put(newStr, Math.min(minDamage, dam));
                    }
                    queue.add(newStr);
                }
            }
        }

        String res = "";
        for (int i = 0; i < ablity.length; i++) {
            res += "0";
        }
        return map.get(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strList = sc.nextLine().split(" ");
        int n = Integer.parseInt(strList[0]);
        int D = Integer.parseInt(strList[1]);
        int[] ablity = new int[n];
        int[] damage = new int[n];
        String[] strsOne = sc.nextLine().split(" ");
        String[] strsTwo = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            ablity[i] = Integer.parseInt(strsOne[i]);
            damage[i] = Integer.parseInt(strsTwo[i]);
        }
        int res = solution(ablity, damage, D);
        System.out.println(res);
    }

}
