package com.UI;
import com.picross.Level;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;


public class InitInterface extends GridPane {
    public InitInterface(Stage primaryStage, Stage stage){
        this.setHgap(10);
        this.setVgap(10);

        Label diff = new Label("Difficoltà:");
        AtomicInteger difficolta = new AtomicInteger(Level.EASY.getValue());
        ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Facile");
        rb1.setToggleGroup(group);
        rb1.setOnMouseClicked(_ -> {
            difficolta.set(Level.EASY.getValue());
        });
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Medio");
        rb2.setToggleGroup(group);
        rb2.setOnMouseClicked(_ -> {
            difficolta.set(Level.MEDIUM.getValue());
        });

        RadioButton rb3 = new RadioButton("Difficile");
        rb3.setToggleGroup(group);
        rb3.setOnMouseClicked(_ -> {
            difficolta.set(Level.HARD.getValue());
        });

        Button b1 = new Button("Inizia");
        b1.setOnMouseClicked(e -> {
            int celle = (difficolta.get()*difficolta.get()*8)/10;
            GameInterface gi = new GameInterface(difficolta.get(), difficolta.get(), celle);
            primaryStage.setTitle("Picross");
            primaryStage.setScene(new Scene(gi, 400, 400));
            primaryStage.show();
            stage.close();
        });

        this.add(diff, 0, 0);
        this.add(rb1, 1, 0);
        this.add(rb2, 2, 0);
        this.add(rb3, 3, 0);
        this.add(b1, 4, 0);
    }
}
