class Solution {

    int count = 0;
    boolean[] col;
    boolean[] diag1;
    boolean[] diag2;

    public int totalNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!col[c] && !diag1[row - c + n] && !diag2[row + c]) {

                col[c] = diag1[row - c + n] = diag2[row + c] = true;
                backtrack(row + 1, n);
                col[c] = diag1[row - c + n] = diag2[row + c] = false;
            }
        }
    }
}
