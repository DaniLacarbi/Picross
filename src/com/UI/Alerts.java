package com.UI;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class Alerts extends Alert {
    Alerts(AlertType alertType) {
        super(alertType);
    }

    public void vittoria(){
        this.setTitle("Vittoria");
        this.setHeaderText("Hai vinto!!!");
        this.showAndWait();
        Platform.exit();
    }

    public void sconfitta(){
        this.setTitle("Morto");
        this.setHeaderText("Sei morto!!!");
        this.showAndWait();
        Platform.exit();
    }

}
