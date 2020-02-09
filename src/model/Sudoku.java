package model;

public class Sudoku {
    private Integer[][] cells = new Integer[9][9];

    public void setCellValue(Integer value, int x, int y) {
        cells[x][y] = value;
    }


    private String cellToString(int x, int y) {
        Integer value = cells[x][y];
        if (value == null) {
            return ".";
        } else {
            return value.toString();
        }
    }

    private String rowToString(int row) {
        return cellToString(0, row) + " " + cellToString(1, row) + " " + cellToString(2, row) + " | " +
                cellToString(3, row) + " " + cellToString(4, row) + " " + cellToString(5, row) + " | " +
                cellToString(6, row) + " " + cellToString(7, row) + " " + cellToString(8, row);
    }

    private static String separator() {
        return "------+-------+------";
    }

    @Override
    public String toString() {
        return rowToString(0) + "\n" + rowToString(1) + "\n" + rowToString(2) + "\n" + separator() + "\n" +
                rowToString(3) + "\n" + rowToString(4) + "\n" + rowToString(5) + "\n" + separator() + "\n" +
                rowToString(6) + "\n" + rowToString(7) + "\n" + rowToString(8);


    }

    public boolean canBeSolved() {
        for (int row = 0; row < 9; row++) {
            boolean containsDuplicates = rowContainsDuplicates(row);
            if (containsDuplicates) {
                return false;
            }
        }
        for (int column = 0; column < 9; column++) {
            boolean containsDuplicates = columnContainsDuplicates(column);
            if (containsDuplicates) {
                return false;
            }
        }
        for (int squareNumber = 0; squareNumber < 9; squareNumber++) {
            boolean containsDuplicates = squareContainsDuplicates(squareNumber);
            if (containsDuplicates) {
                return false;
            }
        }
        return true;
    }

    public boolean rowContainsDuplicates(int row) {
        boolean[] occured = new boolean[9];

        for (int x = 0; x < 9; x++) {
            Integer cellValue = cells[x][row];
            if (cellValue == null) {
                continue;
            }
            if (occured[cellValue - 1]) {
                return true;
            }
            occured[cellValue - 1] = true;
        }
        return false;
    }

    public boolean columnContainsDuplicates(int column) {
        boolean[] occured = new boolean[9];

        for (int y = 0; y < 9; y++) {
            Integer cellValue = cells[column][y];
            if (cellValue == null) {
                continue;
            }
            if (occured[cellValue - 1]) {
                return true;
            }
            occured[cellValue - 1] = true;
        }
        return false;
    }

    public boolean squareContainsDuplicates(int squareNumber) {
        int startX = (squareNumber % 3) * 3;
        int startY = (squareNumber / 3) * 3;
        boolean[] occured = new boolean[9];

        for (int y = startY; y <= startY + 2; y++) {
            for (int x = startX; x <= startX + 2; x++) {
                Integer cellValue = cells[x][y];
                if (cellValue == null) {
                    continue;
                }
                if (occured[cellValue - 1]) {
                    return true;
                }
                occured[cellValue - 1] = true;
            }
        }
        return false;
    }

    public Coordinate findFirstCellWithBlank() {

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (cells[x][y] == null) {
                    return new Coordinate(x, y);
                }
            }
        }
        return null;
    }
}
