package Leetcode._0051;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static List<List<String>> res = new LinkedList<>();

    public static List<List<String>> solveNQueens(int n) {
        LinkedList<String> board = new LinkedList<>();
        String way = "";
        for (int i = 0; i < n; i++) way += ".";
        for (int i = 0; i < n; i++) board.add(way);
        backtrack(0, board);
        return res;
    }

    public static void backtrack(int row, List<String> board) {
        if (row == board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }
        int n = board.size();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            //做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());
            //下一行决策
            backtrack(row+1, board);
            //选择复原
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    public static boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        //检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }
        //检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        //检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            List<String> list = res.get(i);
            for (int j = 0; j < n; j++) {
                System.out.println(list.get(j));
            }
            System.out.println(" ");
        }
    }
}
