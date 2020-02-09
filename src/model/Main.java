package model;

import model.Sudoku;

public class Main {
    public static void main(String[] args) {
        /*
        Sudoku sudoku = new Sudoku();
        sudoku.setCellValue(1, 0, 0);
        sudoku.setCellValue(2, 0, 8);
        sudoku.setCellValue(3, 8, 0);
        sudoku.setCellValue(4, 8, 8);
        System.out.println(sudoku.toString());
        */
        Sudoku sudoku = new Sudoku();
        Sudoku solvedSudoku = SudokuSolver.solve(sudoku);
        System.out.println(solvedSudoku.toString());
    }
}
