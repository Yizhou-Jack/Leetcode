package Interview.netease;

import java.util.*;
import java.util.Scanner;

public class Question1 {

    public static int solution(int n, int city, int[][] messages) {
        int[] routes = new int[n];
        int count = 0;
        for (int i = 0; i < messages.length; i++) {
            if (messages[i][0] == 0) {
                if (messages[i][1] == city) {
                    return i+1;
                } else {
                    if (routes[messages[i][1]-1] == 0) {
                        routes[messages[i][1]-1] = 1;
                        count++;
                    }
                    if (count == n-1) return i+1;
                }
            } else if (messages[i][0] == city || messages[i][1] == city) {
                if (messages[i][0] == city && routes[messages[i][1]-1] == 0) {
                    routes[messages[i][1]-1] = 1;
                    count++;
                }
                if (messages[i][1] == city && routes[messages[i][0]-1] == 0) {
                    routes[messages[i][0]-1] = 1;
                    count++;
                }
            }
            if (count == n-1) return i+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strList = sc.nextLine().split(" ");
        int n = Integer.parseInt(strList[0]);
        int m = Integer.parseInt(strList[1]);
        int city = Integer.parseInt(strList[2]);
        int[][] messages = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] onetwo = sc.nextLine().split(" ");
            int one = Integer.parseInt(onetwo[0]);
            int two = Integer.parseInt(onetwo[1]);
            messages[i] = new int[]{one, two};
        }
        int res = solution(n, city, messages);
        System.out.println(res);
    }

}
