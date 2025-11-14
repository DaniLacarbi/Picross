package com.picross;

import javafx.scene.control.Button;

public class cella extends Button {
    final int dimensions = 100;

    boolean dark;
    boolean pressed;
    boolean wrong;
    boolean chosen;

    cella(boolean dark) {
        this.dark = dark;
        this.pressed = false;
        this.chosen = false;
        this.wrong = false;
        this.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black;");
        this.setPrefWidth(dimensions);
        this.setPrefHeight(dimensions);
    }
    public void pressed() {
        this.pressed = true;
    }

    public boolean isDark(){
        return this.dark;
    }

    public boolean isPressato(){
        return this.pressed;
    }

    public boolean isNotChosen(){
        return !this.chosen;
    }

    public void setChosen(){
        this.chosen = !this.chosen;
    }

    public boolean isWrong(){
        return this.wrong;
    }

    public void setWrong(){
        this.wrong = true;
    }
}
