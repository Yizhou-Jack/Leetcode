package Leetcode._0348;

public class TicTacToe {

    public int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        for(int i = 0; i < board.length; i++){
            if (board[i][col] != player) {
                break;
            }
            if (i == board.length-1) {
                return player;
            }
        }
        for(int i = 0; i < board.length; i++){
            if (board[row][i] != player) {
                break;
            }
            if (i == board.length-1) {
                return player;
            }
        }
        if (row == col) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != player) {
                    break;
                }
                if (i == board.length-1) {
                    return player;
                }
            }
        }
        if (row+col == board.length-1) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length-1-i] != player) {
                    break;
                }
                if (i == board.length-1) {
                    return player;
                }
            }
        }
        return 0;
    }
}
