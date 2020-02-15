package Leetcode._0240;

import javafx.util.Pair;

import java.util.*;

public class Solution1 {

    /*
    BFS解法：非常垃圾
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        boolean[][] hasCheck = new boolean[rows][cols];

        int m;
        int n;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> num = queue.remove();
            m = num.getKey();
            n = num.getValue();
            if (hasCheck[m][n]) continue;
            if (matrix[m][n] == target) return true;
            else hasCheck[m][n] = true;
            if (matrix[m][n] < target) {
                if (checkValid(m+1, n, matrix) && !hasCheck[m+1][n]) queue.add(new Pair<>(m+1, n));
                if (checkValid(m, n+1, matrix) && !hasCheck[m][n+1]) queue.add(new Pair<>(m, n+1));
            } else {
                if (checkValid(m-1, n, matrix) && !hasCheck[m-1][n]) queue.add(new Pair<>(m-1, n));
                if (checkValid(m, n-1, matrix) && !hasCheck[m][n-1]) queue.add(new Pair<>(m, n-1));
            }
        }
        return false;
    }

    public boolean checkValid(int i, int j, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        return (i <= rows-1 && i >= 0 && j <= cols-1 && j >= 0);
    }
}
