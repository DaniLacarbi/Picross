package com.picross;

public enum Livello {
    FACILE(80), MEDIO(50), DIFFICILE(30);
    private final int value;

    Livello(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
