package se.linda.gamecenter.FXComponenets;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import se.linda.gamecenter.Constants;
import se.linda.gamecenter.Controllers.GameSelector;
import se.linda.gamecenter.Functions.SceneLuncher;

public class AlertButton {
    private ButtonType no;
    private ButtonType yes;

    public AlertButton() {
        this.no = new ButtonType("No");
        this.yes = new ButtonType("Yes");
    }

    public void addButtons(Alert alert, Stage oldStage, String game) {
        alert.getButtonTypes().setAll(yes, no);
        setFunctions(alert, oldStage, game);
    }

    private void setFunctions(Alert alert, Stage oldStage, String game) {
        Button tempYes = (Button) alert.getDialogPane().lookupButton(yes);
        tempYes.setOnAction(actionEvent -> {
            oldStage.close();
            SceneLuncher mainApp = new SceneLuncher(new GameSelector(Constants.games).getGame(game));
            Stage stage = new Stage();
            stage.setScene(mainApp.load());
            stage.show();
        });
        Button tempNo = (Button) alert.getDialogPane().lookupButton(no);
        tempNo.setOnAction(actionEvent -> {
            alert.close();
            oldStage.close();
        });
    }
}
