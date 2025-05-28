package se.linda.gamecenter.Functions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.linda.gamecenter.FXComponenets.AlertButton;

import java.util.List;

public class Alerts extends Alert{
    private String title;
    private AlertType type;
    private String message;
    private Alert alert;
    private AlertButton buttons;

    public Alerts (String title, String message, AlertType type) {
        super(type);
        this.title = title;
        this.message = message;
        this.type = type;
        this.alert = new Alert(this.type, this.message);
        this.buttons = new AlertButton();
    }

    public void showAlert(Stage stage, String game) {
        alert.setTitle(this.title);
        alert.setHeaderText("Play a new game?");
        buttons.addButtons(alert, stage, game);
        alert.show();
    }
}
