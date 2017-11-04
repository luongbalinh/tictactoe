package oo;

public class Cell {

    private int row;
    private int col;
    private Seed seed;

    public Cell(int row, int col, Seed seed) {
        this.row = row;
        this.col = col;
        this.seed = seed;
    }

    public Cell(int row, int col) {
        this(row, col, Seed.EMPTY);
    }

    @Override
    public String toString() {
        return seed.toString();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }
}