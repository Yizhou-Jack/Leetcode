package Leetcode._0174;

public class Solution1 {

    /*
    超时
     */

    public static int res = Integer.MAX_VALUE;

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        dfs(0,0,m,n,dungeon,1,1);
        return res;
    }

    public static void dfs(int x, int y, int m, int n, int[][] dungeon, int minNeed, int nowPoint) {
        if (x >= m || x < 0 || y >= n || y < 0) return;
        if (minNeed > res) return;

        nowPoint += dungeon[x][y];
        minNeed = nowPoint > 0 ? minNeed : minNeed-nowPoint+1;
        if (x == m-1 && y == n-1) {
            res = Math.min(res, minNeed);
            return;
        }
        nowPoint = nowPoint > 0 ? nowPoint : 1;
        dfs(x+1, y, m, n, dungeon, minNeed, nowPoint);
        dfs(x, y+1, m, n, dungeon, minNeed, nowPoint);
    }

    public static void main(String[] args) {
        int[] d1 = new int[]{1,-3,3};
        int[] d2 = new int[]{0,-2,0};
        int[] d3 = new int[]{-3,-3,-3};
        int[][] dungeon = new int[][]{d1,d2,d3};
        int res = calculateMinimumHP(dungeon);
        System.out.println(res);
    }
}
