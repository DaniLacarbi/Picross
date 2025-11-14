package com.picross;

import javafx.scene.control.Button;

public class cella extends Button {
    boolean dark;
    boolean pressed;
    boolean chosen;
    cella(boolean dark) {
        this.dark = dark;
        this.pressed = false;
        this.chosen = false;
        this.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black;");
        this.setPrefWidth(100);
        this.setPrefHeight(100);
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

    public boolean isChosen(){
        return this.chosen;
    }

    public void setChosen(){
        this.chosen = !this.chosen;
    }

}
