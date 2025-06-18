package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se.linda.gamecenter.Constructors.Selectors;
import se.linda.gamecenter.Functions.Alerts;

public interface BaseGame extends Selectors {

    Scene Start();

    default void reRun(Alerts alerts, Pane mainGrid, String game) {
        alerts.showAlert((Stage) mainGrid.getScene().getWindow(), game);
    }

}
