package model;

public class SudokuSolver {
    public static Sudoku solve(Sudoku sudoku) {
        if (!sudoku.canBeSolved()) {
            return null;
        }
        Coordinate c = sudoku.findFirstCellWithBlank();
        if (c == null) {
            return sudoku;
        }
        for (int i = 1; i <= 9; i++) {
            sudoku.setCellValue(i, c.getX(), c.getY());
            Sudoku maybeSolved = solve(sudoku);
            if (maybeSolved != null) {
                return maybeSolved;
            }
        }
        sudoku.setCellValue(null, c.getX(), c.getY());
        return null;
    }
}
