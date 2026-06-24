class Solution {
    public boolean solve(int i, int j, int idx, char[][] board, String word) {
        // 1. Success base case: entire word matched
        if (idx == word.length()) {
            return true;
        }
        
        // 2. Failure base case: out of bounds or character mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        // 3. Mark the current cell as visited (backtracking trick)
        char temp = board[i][j];
        board[i][j] = '#'; 
        
        // 4. Explore 4 cardinal directions (Up, Down, Left, Right)
        boolean found = solve(i + 1, j, idx + 1, board, word) || // Down
                        solve(i - 1, j, idx + 1, board, word) || // Up
                        solve(i, j + 1, idx + 1, board, word) || // Right
                        solve(i, j - 1, idx + 1, board, word);   // Left
        
        // 5. Restore the cell back to its original value
        board[i][j] = temp;
        
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches, kick off the search
                if (board[i][j] == word.charAt(0)) {
                    if (solve(i, j, 0, board, word)) {
                        return true; // Only return true if a full match is found
                    }
                }
            }
        }
        return false;
    }
}
