package oo;

public enum Seed {
    EMPTY("   "), CROSS(" X "), NOUGHT(" O ");

    String value;

    Seed(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}