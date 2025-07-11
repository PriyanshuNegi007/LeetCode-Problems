class Solution {
    boolean board[][];

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return countPos(0, n);  // Start the recursion from the first row
    }

    // Check if it's safe to place a queen at (row, col)
    private boolean isSafe(int row, int col, int n) {
        // Checking the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Checking left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Checking right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to count solutions
    public int countPos(int row, int n) {
        // If we've placed queens in all rows, return 1 (a valid configuration)
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try placing a queen in all columns for the current row
        for (int col = 0; col < n; col++) {
            // If it's safe to place the queen at (row, col)
            if (isSafe(row, col,n)) {
                // Place the queen
                board[row][col] = true;

                // Recur to place queens in the next row
                count += countPos(row + 1, n);

                // Backtrack by removing the queen
                board[row][col] = false;
            }
        }
        return count;
    }
}
