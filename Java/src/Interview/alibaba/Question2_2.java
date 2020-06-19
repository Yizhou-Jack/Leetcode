package Interview.alibaba;

import java.util.*;

public class Question2_2 {

    public static int bfs(int n, int m, char[][] matrix) {
        int res = Integer.MAX_VALUE;

        int[][][] dp = new int[n][m][5];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'S') {
                    dp[i][j][0] = 0;
                    queue.add(new int[]{i,j,0});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int fly = point[2];
            int step = dp[x][y][fly];
            if (matrix[x][y] == 'E') {
                res = dp[x][y][fly];
                break;
            }
            if (x+1 < n && matrix[x+1][y] != '#') {
                queue.add(new int[]{x+1, y, fly});
                dp[x+1][y][fly] = step+1;
            }
            if (x-1 >= 0 && matrix[x-1][y] != '#') {
                queue.add(new int[]{x-1, y, fly});
                dp[x-1][y][fly] = step+1;
            }
            if (y+1 < m && matrix[x][y+1] != '#') {
                queue.add(new int[]{x, y+1, fly});
                dp[x][y+1][fly] = step+1;
            }
            if (y-1 >= 0 && matrix[x][y-1] != '#') {
                queue.add(new int[]{x, y-1, fly});
                dp[x][y-1][fly] = step+1;
            }
            if (fly < 5 && matrix[n-1-x][m-1-y] != '#') {
                queue.add(new int[]{n-1-x, m-1-y, fly+1});
                dp[n-1-x][m-1-y][fly+1] = step+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] input = new char[n][m];
        for(int i = 0; i < n; i++){
            char[] line = sc.nextLine().toCharArray();
            input[i] = line;
        }
        int res = bfs(n, m, input);
        System.out.println(res);
    }
}
