class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {  
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                           
                            if (solve(board)) {
                                return true; 
                            }
                            board[row][col] = '.'; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false; 
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false; 
            }
        }

        // Check 3x3  small grid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false; 
                }
            }
        }
        return true;
    }
}
