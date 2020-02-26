package Leetcode._0794;

public class Solution1 {

    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') countX++;
                if (board[i].charAt(j) == 'O') countO++;
            }
        }
        if (countX > countO+1 || countX < countO) return false;

        boolean Xwin = false;
        boolean Owin = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) &&
                    board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(i) == 'X') Xwin = true;
                if (board[i].charAt(i) == 'O') Owin = true;
            }
        }
        for (int i = 0; i < board[0].length(); i++) {
            if (board[0].charAt(i) == board[1].charAt(i) &&
                    board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'X') Xwin = true;
                if (board[0].charAt(i) == 'O') Owin = true;
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) &&
                board[0].charAt(0) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'X') Xwin = true;
            if (board[0].charAt(0) == 'O') Owin = true;
        }
        if (board[0].charAt(2) == board[1].charAt(1) &&
                board[0].charAt(2) == board[2].charAt(0)) {
            if (board[0].charAt(2) == 'X') Xwin = true;
            if (board[0].charAt(2) == 'O') Owin = true;
        }

        if (Xwin && !Owin && countX == countO+1) return true;
        if (!Xwin && Owin && countX == countO) return true;
        if (!Xwin && !Owin) return true;
        return false;
    }
}
