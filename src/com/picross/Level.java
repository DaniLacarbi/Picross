package com.picross;

public enum Level {
    EASY(6), MEDIUM(8), HARD(10);
    private final int value;

    Level(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
