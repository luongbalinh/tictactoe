package oo.generalized;

import oo.Cell;
import oo.Seed;

public class Board {

    int rows;
    int cols;
    private int winLength;
    private Cell[][] cells;

    public Board(int m, int n, int k) {
        rows = m;
        cols = n;
        winLength = k;
        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (cells[row][col].getSeed() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(Cell cell) {
        return (checkRow(cell) || checkColumn(cell) || checkDiagonal(cell) || checkOppositeDiagonal(cell));
    }

    public void show() {
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                System.out.print(cells[row][col]);
                if (col < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < rows - 1) {
                System.out.println("-----------------------------");
            }
        }
    }

    private boolean checkRow(Cell nextCell) {
        Seed[] seeds = new Seed[cols];

        for (int i = 0; i < cols; i++) {
            seeds[i] = cells[nextCell.getRow()][i].getSeed();
        }

        return checkWin(seeds, nextCell.getCol(), winLength);
    }

    private boolean checkColumn(Cell nextCell) {
        Seed[] seeds = new Seed[rows];

        for (int i = 0; i < rows; i++) {
            seeds[i] = cells[i][nextCell.getCol()].getSeed();
        }

        return checkWin(seeds, nextCell.getRow(), winLength);
    }

    private boolean checkDiagonal(Cell nextCell) {

        int i = nextCell.getRow();
        int j = nextCell.getCol();
        int deltaMin = -Math.min(i, j);
        int deltaMax = Math.min(rows - 1 - i, cols - 1 - j);
        Seed[] seeds = new Seed[deltaMax - deltaMin + 1];

        int runner = 0;
        for (int k = deltaMin; k <= deltaMax; k++) {
            seeds[runner++] = cells[i + k][j + k].getSeed();
        }

        return checkWin(seeds, nextCell.getRow(), winLength);
    }

    private boolean checkOppositeDiagonal(Cell nextCell) {
        int i = nextCell.getRow();
        int j = nextCell.getCol();

        int deltaMin = -Math.min(rows - 1 - i, j);
        int deltaMax = Math.min(cols - 1 - j, i);
        Seed[] seeds = new Seed[deltaMax - deltaMin + 1];

        int runner = 0;
        for (int k = deltaMin; k <= deltaMax; k++) {
            seeds[runner++] = cells[i - k][j + k].getSeed();
        }

        return checkWin(seeds, nextCell.getCol(), winLength);
    }

    public static boolean checkWin(Seed[] a, int index, int winLength) {
        int count = 0;
        int i = index;
        boolean isMovingLeft = true;

        while (count < winLength && i < a.length) {
            if (isMovingLeft) {
                if (a[i] != a[index]) {
                    isMovingLeft = false;
                    i = index + 1;
                } else {
                    if (i == 0) {
                        isMovingLeft = false;
                        i = index + 1;
                    } else {
                        i--;
                    }
                    count++;
                }
            } else {
                if (a[i] != a[index]) {
                    break;
                } else {
                    count++;
                    i++;
                }
            }
        }

        return count == winLength;
    }

    public Cell[][] getCells() {
        return cells;
    }

}