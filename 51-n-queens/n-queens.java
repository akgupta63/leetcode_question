import java.util.*;

class Solution {

    List<List<String>> result = new ArrayList<>();
    boolean[] col;
    boolean[] diag1;
    boolean[] diag2;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result.add(constructBoard(n));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !diag1[row - c + n] && !diag2[row + c]) {

                board[row][c] = 'Q';
                col[c] = diag1[row - c + n] = diag2[row + c] = true;

                backtrack(row + 1, n);

                board[row][c] = '.';
                col[c] = diag1[row - c + n] = diag2[row + c] = false;
            }
        }
    }

    private List<String> constructBoard(int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            temp.add(new String(board[i]));
        return temp;
    }
}
