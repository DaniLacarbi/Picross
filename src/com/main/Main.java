package com.main;

import com.UI.InitInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        stage.setTitle("Inizio");
        InitInterface initInterface = new InitInterface(primaryStage, stage);
        stage.setScene(new Scene(initInterface, 350, 50));
        stage.show();
    }
}
