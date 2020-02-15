package Leetcode._0200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    /*
    BFS标准解法
    */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    Queue<Integer> neighbor = new LinkedList<>();
                    neighbor.add(i * cols + j);
                    while (!neighbor.isEmpty()) {
                        int id = neighbor.remove();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbor.add((row-1) * cols + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row+1][col] == '1') {
                            neighbor.add((row+1) * cols + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbor.add(row * cols + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col+1] == '1') {
                            neighbor.add(row * cols + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return res;
    }

}
