package com.picross;

public enum Livello {
    FACILE(6), MEDIO(8), DIFFICILE(10);
    private final int value;

    Livello(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
