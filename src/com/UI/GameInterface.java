package com.UI;
import com.picross.cella;
import com.picross.cellasMap;
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

    cellasMap map;
    int width;
    int height;
    int celleScure;
    int maxVite;

    public GameInterface(int width, int height, int celleScure){
        this.map  = new cellasMap(width,height,celleScure);
        this.width  = width+1;
        this.height = height+1;
        this.celleScure = celleScure;
        this.maxVite = celleScure/5;
        updateUI();
    }

    public void updateUI(){
        this.getChildren().clear();
        addLabels();
        addButtons();
        showLives();
        mostraAvvisi();
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
            int dark = this.map.contaDarkRighe(i-1);
            Label l = darkLabel(dark);
            this.add(l, 0, i);
        }

        for(int i = 1; i < height; i++){
            int dark = this.map.contaDarkColonne(i-1);
            Label l = darkLabel(dark);
            this.add(l, i, 0);
        }
    }

    void buttonLogic(MouseEvent e, cella c){
        if (e.getButton() == MouseButton.SECONDARY) {
            if(c.isNotChosen()) {
                c.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-border-color: black;");
            }
            else {
                c.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black;");
            }
            c.setChosen();
        }

        else if (e.getButton() == MouseButton.PRIMARY) {
            if (c.isNotChosen() && !c.isPressato()) {
                if (c.isDark()) {
                    c.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-border-color: black;");
                } else {
                    c.setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-border-color: black;");
                    maxVite--;
                    c.setWrong();
                }
                c.pressed();
            }
        }
    }

    void addButtons(){
        for(int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                cella c = map.getCella(i - 1, j - 1);
                c.setOnMouseClicked((MouseEvent e) -> {
                    buttonLogic(e, c);
                    updateUI();
                });
                this.add(c, i, j);
            }
        }
    }

    void showLives(){
        Label lives = new Label("Vite: " + this.maxVite);
        lives.setFont(new Font(20));
        this.add(lives, 0, width);
    }

    void mostraAvvisi(){
        if (map.isVerificato()){
            Alerts alert = new Alerts(Alert.AlertType.INFORMATION);
            alert.vittoria();
        } else if (this.maxVite == 0){
            Alerts alert = new Alerts(Alert.AlertType.ERROR);
            alert.sconfitta();
        }
    }

}
