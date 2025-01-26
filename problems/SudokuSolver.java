import java.util.HashMap;
import java.util.Map;

public class SudokuSolver {

    public static void main(String[] args) {
        // Test Case 1
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board1);
        System.out.println("Solved Sudoku:");
        solver.printBoard(board1);
    }

    public void solveSudoku(char[][] board) {
        // Initialize data structures for rows, columns, and boxes
        Map<Character, Boolean>[] boxes = new HashMap[9];
        Map<Character, Boolean>[] rows = new HashMap[9];
        Map<Character, Boolean>[] cols = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            boxes[i] = new HashMap<>();
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
        }

        // Helper function to determine the box index
        int getBoxIndex(int row, int col) {
            return (row / 3) * 3 + (col / 3);
        }

        // Populate the initial state of the board into rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    int boxIndex = getBoxIndex(i, j);
                    boxes[boxIndex].put(value, true);
                    rows[i].put(value, true);
                    cols[j].put(value, true);
                }
            }
        }

        // Backtracking function
        boolean solveBacktrack(char[][] board, Map<Character, Boolean>[] boxes, 
                               Map<Character, Boolean>[] rows, Map<Character, Boolean>[] cols, 
                               int row, int col) {
            if (row == 9) return true; // Reached the end of the board

            // Move to the next row if the column index exceeds 8
            if (col == 9) return solveBacktrack(board, boxes, rows, cols, row + 1, 0);

            // Skip pre-filled cells
            if (board[row][col] != '.') return solveBacktrack(board, boxes, rows, cols, row, col + 1);

            int boxIndex = getBoxIndex(row, col);

            // Try placing numbers 1-9
            for (char num = '1'; num <= '9'; num++) {
                if (isValid(boxes[boxIndex], rows[row], cols[col], num)) {
                    board[row][col] = num;
                    boxes[boxIndex].put(num, true);
                    rows[row].put(num, true);
                    cols[col].put(num, true);

                    if (solveBacktrack(board, boxes, rows, cols, row, col + 1)) return true;

                    // Backtrack
                    board[row][col] = '.';
                    boxes[boxIndex].remove(num);
                    rows[row].remove(num);
                    cols[col].remove(num);
                }
            }

            return false; // No valid placement found
        }

        // Helper function to check if placing a number is valid
        boolean isValid(Map<Character, Boolean> box, Map<Character, Boolean> row, Map<Character, Boolean> col, char num) {
            return !box.containsKey(num) && !row.containsKey(num) && !col.containsKey(num);
        }

        solveBacktrack(board, boxes, rows, cols, 0, 0);
    }

    // Helper function to print the Sudoku board
    public void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}public class SudokuSolver {

}
