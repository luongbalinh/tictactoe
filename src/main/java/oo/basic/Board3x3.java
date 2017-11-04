package oo.basic;

import oo.Cell;
import oo.Seed;

public class Board3x3 {

    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cell[][] cells;
    int currentRow;
    int currentCol;

    public Board3x3() {
        cells = new Cell[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].getSeed() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(Seed seed) {
        return (checkRow(seed) || checkColumn(seed) || checkDiagonal(seed) || checkOppositeDiagonal(seed));
    }

    public void show() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                System.out.print(cells[row][col]);
                if (col < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }

    private boolean checkRow(Seed seed) {
        return cells[currentRow][0].getSeed() == seed
                && cells[currentRow][1].getSeed() == seed
                && cells[currentRow][2].getSeed() == seed;
    }

    private boolean checkColumn(Seed seed) {
        return cells[0][currentCol].getSeed() == seed
                && cells[1][currentCol].getSeed() == seed
                && cells[2][currentCol].getSeed() == seed;
    }

    private boolean checkDiagonal(Seed seed) {
        return currentRow == currentCol
                && cells[0][0].getSeed() == seed
                && cells[1][1].getSeed() == seed
                && cells[2][2].getSeed() == seed;
    }

    private boolean checkOppositeDiagonal(Seed seed) {
        return currentRow + currentCol == 2
                && cells[0][2].getSeed() == seed
                && cells[1][1].getSeed() == seed
                && cells[2][0].getSeed() == seed;
    }
}