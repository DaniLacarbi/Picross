package com.UI;
import com.picross.Cell;
import com.picross.CellsMap;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GameInterface extends GridPane {
    final int prefWidth = 50;
    final int prefHeight = 50;
    final int fontSize = 20;
    final int livesRatio = 6;

    CellsMap map;
    int width;
    int height;
    int darkCells;
    int darksToShow;
    int lives;

    public GameInterface(int width, int height, int celleScure){
        this.map  = new CellsMap(width,height,celleScure);
        this.width  = width+1;
        this.height = height+1;
        this.darkCells = celleScure;
        this.darksToShow = celleScure;
        this.lives = celleScure/livesRatio;
        updateUI();
    }

    public void updateUI(){
        this.getChildren().clear();
        addLabels();
        addButtons();
        showLabels();
        showAlerts();
    }

    Label darkLabel(int dark){
        Label b = new Label(String.valueOf(dark));
        b.setPrefWidth(prefWidth);
        b.setPrefHeight(prefHeight);
        b.setFont(new Font(fontSize));
        b.setAlignment(Pos.CENTER);
        return b;
    }

    void addLabels(){
        for(int i = 1; i < width; i++){
            int dark = this.map.countDarkInRows(i-1);
            Label l = darkLabel(dark);
            this.add(l, 0, i);
        }

        for(int i = 1; i < height; i++){
            int dark = this.map.countDarkInColumns(i-1);
            Label l = darkLabel(dark);
            this.add(l, i, 0);
        }
    }

    void buttonLogic(MouseEvent e, Cell c){
        if (e.getButton() == MouseButton.SECONDARY) {
            if (c.isNotChosen()) {
                c.setStyle("-fx-background-color: #0692ef; " +
                        "-fx-text-fill: white; -fx-border-color: black;");
            }
            else {
                c.setStyle("-fx-background-color: white; " +
                        "-fx-text-fill: black; -fx-border-color: black;");
            }
            c.setChosen();
        }

        else if (e.getButton() == MouseButton.PRIMARY) {
            if (c.isNotChosen() && c.isNotPressed()) {
                if (c.isDark()) {
                    c.setStyle("-fx-background-color: rgba(0,0,0,0.5); " +
                            "-fx-text-fill: white; -fx-border-color: black;");
                    darksToShow--;
                } else {
                    c.setStyle("-fx-background-color: #f63f3f; " +
                            "-fx-text-fill: black; -fx-border-color: black;");
                    lives--;
                }
                c.pressed();
            }
        }
    }

    void addButtons(){
        for(int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                Cell c = map.getCell(i - 1, j - 1);
                c.setOnMouseClicked((MouseEvent e) -> {
                    buttonLogic(e, c);
                    updateUI();
                });
                this.add(c, i, j);
            }
        }
    }

    void showLabels(){
        Label lives = new Label("Vite: " + this.lives);
        lives.setFont(new Font(20));
        this.add(lives, 0, width);

        Label cells = new Label("Cells: " + this.darksToShow);
        cells.setFont(new Font(20));
        this.add(cells, 2, width);
    }

    void showAlerts(){
        if (darksToShow == 0 && lives != 0){
            Alerts alert = new Alerts(Alert.AlertType.INFORMATION);
            alert.victory();
        } else if (this.lives <= 0){
            Alerts alert = new Alerts(Alert.AlertType.ERROR);
            alert.defeat();
        }
    }

}
