package _0064;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {

    /*
    BFS方法：超时
    */

    public int[][] dirs = new int[][]{{0,1},{1,0}};

    public int minPathSum(int[][] grid) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { //这里是小根堆
                return a[2] - b[2]; //第一键值做参考
            }
        };
        Queue<int[]> queue = new PriorityQueue<>(cmp);
        queue.add(new int[]{0,0,grid[0][0]});

        int row = grid.length;
        int col = grid[0].length;
        while (!queue.isEmpty()) {
            int[] sub = queue.remove();
            if (sub[0] == row-1 && sub[1] == col-1) return sub[2];
            for (int[] dir : dirs) {
                if (checkValid(grid, sub[0]+dir[0], sub[1]+dir[1])) {
                    queue.add(new int[]{sub[0]+dir[0], sub[1]+dir[1], sub[2]+grid[sub[0]+dir[0]][sub[1]+dir[1]]});
                }
            }
        }
        return 0;
    }

    public boolean checkValid(int[][] grid, int i, int j) {
        if (i < grid.length && j < grid[0].length) return true;
        else return false;
    }
}
