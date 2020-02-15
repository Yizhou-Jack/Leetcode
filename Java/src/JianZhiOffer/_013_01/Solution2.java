package JianZhiOffer._013_01;

public class Solution2 {

    public int res = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,k,visited);
        return res;
    }

    public void dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x >= m || x < 0 || y >= n || y < 0 || !checkValid(x,y,k)|| visited[x][y]) return;
        res++;
        visited[x][y] = true;
        dfs(x+1, y, m, n, k, visited);
        dfs(x-1, y, m, n, k, visited);
        dfs(x, y+1, m, n, k, visited);
        dfs(x, y-1, m, n, k, visited);
    }

    public boolean checkValid(int x, int y, int k) {
        int sum = 0;
        while (x > 0) {
            sum += x%10;
            x /= 10;
        }
        while (y > 0) {
            sum += y%10;
            y /= 10;
        }
        return sum <= k;
    }
}
