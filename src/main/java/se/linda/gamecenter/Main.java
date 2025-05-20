package se.linda.gamecenter;

import javafx.application.Application;
import javafx.stage.Stage;
import se.linda.gamecenter.Functions.SceneLuncher;
import se.linda.gamecenter.Games.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SceneLuncher mainApp = new SceneLuncher(new RobotGame(12));
        stage.setScene(mainApp.load());
        stage.show();
    }
}