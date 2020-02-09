package model;

import model.Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, BadFormatException {

        Sudoku sudoku = readSudokuFromFile("sudoku.txt");

        Sudoku solvedSudoku = SudokuSolver.solve(sudoku);

        System.out.println(solvedSudoku.toString());
//        System.out.println("Working Directory = " + System.getProperty("user.dir")); // Var du måste placera din fil

        /*
        Sudoku sudoku = new Sudoku();
        sudoku.setCellValue(1, 0, 0);
        sudoku.setCellValue(2, 0, 8);
        sudoku.setCellValue(3, 8, 0);
        sudoku.setCellValue(4, 8, 8);
        System.out.println(sudoku.toString());

        Sudoku sudoku = new Sudoku();
        Sudoku solvedSudoku = SudokuSolver.solve(sudoku);
        System.out.println(solvedSudoku.toString());

         */
    }

    public static Sudoku readSudokuFromFile(String fileName) throws FileNotFoundException, BadFormatException {
        Sudoku sudoku = new Sudoku();
        Scanner scanner = new Scanner(new File(fileName));

        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            fillRowInSudoku(sudoku, i, line);
        }

        if (scanner.hasNext()) {
            throw new BadFormatException("Sudoku must be exactly 9 lines");
        }

        scanner.close();
        return sudoku;
    }

    private static void fillRowInSudoku(Sudoku sudoku, int row, String data) throws BadFormatException {
        if (data.length() != 9) {
            throw new BadFormatException("Each line of the Sudoku must be 9 characters each");
        }
        for (int column = 0; column < 9; column++) {
            char characterFetched = data.charAt(column);
            if (characterFetched == '.') {
                continue;
            }
            int intRepresentation = Integer.parseInt(String.valueOf(characterFetched));
            if (intRepresentation >= 1 && intRepresentation <= 9) {
                sudoku.setCellValue(intRepresentation, column, row);
            } else {
                throw new BadFormatException("Found invalid character. Must be '.' or number between 1 and 9");
            }
        }
    }
}
