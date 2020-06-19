package Interview.alibaba;

import java.util.*;

public class Question2 {

    public static int res = Integer.MAX_VALUE;

    public static int DFSRecursion(int n, int m, char[][] matrix) {
        boolean[][] visited = new boolean[n][m];
        int step = 0;
        int fly = 5;
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'S') {
                    startI = i;
                    startJ = j;
                }
            }
        }
        dfs(startI, startJ, step, fly, n, m, visited, matrix);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public static void dfs(int x, int y, int step, int fly, int n, int m, boolean[][] visited, char[][] matrix) {
        if (x >= n || x < 0 || y >= m || y < 0 || matrix[x][y] == '#') return;
        if (matrix[x][y] == 'E') {
            res = Math.min(res, step);
            return;
        }
        if (!visited[n-1-x][m-1-y]) {
            visited[n - 1 - x][m - 1 - y] = true;
            if (fly > 0) dfs(n - 1 - x, m - 1 - y, step + 1, fly - 1, n, m, visited, matrix);
            visited[n - 1 - x][m - 1 - y] = false;
        }
        if (x+1 < n && !visited[x+1][y]) {
            visited[x + 1][y] = true;
            dfs(x + 1, y, step + 1, fly, n, m, visited, matrix);
            visited[x + 1][y] = false;
        }
        if (x-1 >= 0 && !visited[x-1][y]) {
            visited[x - 1][y] = true;
            dfs(x - 1, y, step + 1, fly, n, m, visited, matrix);
            visited[x - 1][y] = false;
        }
        if (y+1 < m && !visited[x][y+1]) {
            visited[x][y + 1] = true;
            dfs(x, y + 1, step + 1, fly, n, m, visited, matrix);
            visited[x][y + 1] = false;
        }
        if (y-1 >= 0 && !visited[x][y-1]) {
            visited[x][y - 1] = true;
            dfs(x, y - 1, step + 1, fly, n, m, visited, matrix);
            visited[x][y - 1] = false;
        }
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
        int res = DFSRecursion(n, m, input);
        System.out.println(res);
    }
}